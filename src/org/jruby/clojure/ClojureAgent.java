package org.jruby.clojure;


import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.RubyObject;
import org.jruby.anno.JRubyMethod;
import org.jruby.anno.JRubyClass;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;
import clojure.lang.Agent;
import clojure.lang.ISeq;
import clojure.lang.RT;
import clojure.lang.ArraySeq;
import org.jruby.javasupport.JavaUtil;
import org.jruby.runtime.Block;
import org.jruby.RubyBoolean;
import static org.jruby.runtime.Visibility.*;

@JRubyClass(name = "Agent")
public class ClojureAgent extends RubyObject {

  public static RubyClass createAgentClass(Ruby runtime) {
    RubyClass agentc = runtime.defineClass("Agent", runtime.getObject(), AGENT_ALLOCATOR);
      agentc.setReifiedClass(ClojureAgent.class);
      agentc.kindOf = new RubyModule.KindOf() {
        @Override
        public boolean isKindOf(IRubyObject obj, RubyModule type) {
          return obj instanceof ClojureAgent;
        }
      };
      agentc.defineAnnotatedMethods(ClojureAgent.class);
      return agentc;
    }

    private static ObjectAllocator AGENT_ALLOCATOR = new ObjectAllocator() {
      public IRubyObject allocate(Ruby runtime, RubyClass klass) {
        return new ClojureAgent(runtime, klass);
      }
    };

  Ruby ruby;
  Agent agent;

  ClojureAgent(Ruby runtime, RubyClass klass) {
    super(runtime, klass);
    ruby = null;
    agent = null;
  }

  @JRubyMethod(name = "shutdown", meta = true)
  public static IRubyObject shutdown(ThreadContext context, IRubyObject recv) {
    Agent.shutdown();
    return context.getRuntime().getNil();
  }
  
  @JRubyMethod(visibility = PRIVATE)
  public IRubyObject initialize(final ThreadContext context, final IRubyObject state, Block block) {
    ruby = context.getRuntime();
    try {
      agent = new Agent(state);
      this.setErrorHandler(context, block);
    } catch (Exception e) {
      throw ruby.newConcurrencyError(e.getLocalizedMessage());
    }
    return this;
  }

  @JRubyMethod(name = "dispatch", rest = true)
  public IRubyObject dispatch(final ThreadContext context, final IRubyObject[] args, final Block block) {
    agent.dispatch( new ClojureFunction(context, block), ArraySeq.create((Object[])args), true);
    return ruby.getNil();
  }

  @JRubyMethod
  public Object deref(final ThreadContext context) {
    try {
      return agent.deref();
    } catch (Exception e) {
      throw context.getRuntime().newConcurrencyError(e.getLocalizedMessage());
    }
  }

  @JRubyMethod(name = "get_error")
  public Object getError(final ThreadContext context) {
    return agent.getError();
  }

  @JRubyMethod
  public Object restart(final ThreadContext context, final IRubyObject newState) {
    return restart(context, newState, new RubyBoolean(context.getRuntime(), true));
  }

  @JRubyMethod
  public Object restart(final ThreadContext context, final IRubyObject newState, final IRubyObject clearActions) {
    try {
      return agent.restart(newState, clearActions.isTrue());
    } catch (Exception e) {
      throw context.getRuntime().newConcurrencyError(e.getLocalizedMessage());
    }
  }

  @JRubyMethod(name = "set_error_handler")
  public IRubyObject setErrorHandler(final ThreadContext context, final Block block) {
    agent.setErrorHandler(new ClojureFunction(context, block));
    return context.getRuntime().getNil();
  }
}