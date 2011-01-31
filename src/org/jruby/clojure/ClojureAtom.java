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
import org.jruby.runtime.Block;
import clojure.lang.Atom;
import clojure.lang.ArraySeq;
import static org.jruby.runtime.Visibility.*;

@JRubyClass(name = "Atom")
public class ClojureAtom extends RubyObject {

  public static RubyClass createAtomClass(final Ruby runtime) {
    RubyClass atomc = runtime.defineClass("Atom", runtime.getObject(), ATOM_ALLOCATOR);
    atomc.setReifiedClass(ClojureAtom.class);
    atomc.kindOf = new RubyModule.KindOf() {
      @Override
      public boolean isKindOf(IRubyObject obj, RubyModule type) {
        return obj instanceof ClojureAtom;
      }
    };
    atomc.defineAnnotatedMethods(ClojureAtom.class);
    return atomc;
  }
  
  Atom atom;

  private static ObjectAllocator ATOM_ALLOCATOR = new ObjectAllocator() {
    public IRubyObject allocate(final Ruby runtime, final RubyClass klass) {
      return new ClojureAtom(runtime, klass);
    }
  };

  public ClojureAtom(final Ruby runtime, final RubyClass klass) {
    super(runtime, klass);
    atom = null;
  }
  
  @JRubyMethod(visibility = PRIVATE)
  public IRubyObject initialize(final ThreadContext context, final IRubyObject state) {
    try {
      atom = new Atom(state);
    } catch (Exception e) {
      throw context.getRuntime().newConcurrencyError(e.getLocalizedMessage());
    }
    return this;
  }
  
  @JRubyMethod
  public Object swap(final ThreadContext context, final Block block) {
    try {
      return atom.swap(new ClojureFunction(context, block));
    } catch (Exception e) {
      throw context.getRuntime().newConcurrencyError(e.getLocalizedMessage());
    }
  }
  
  @JRubyMethod
  public Object swap(final ThreadContext context, final IRubyObject arg0, final Block block) {
    try {
      return atom.swap(new ClojureFunction(context, block), arg0);
    } catch (Exception e) {
      throw context.getRuntime().newConcurrencyError(e.getLocalizedMessage());
    }
  }
  
  @JRubyMethod
  public Object swap(final ThreadContext context, final IRubyObject arg0, final IRubyObject arg1, final Block block) {
    try {
      return atom.swap(new ClojureFunction(context, block), arg0, arg1);
    } catch (Exception e) {
      throw context.getRuntime().newConcurrencyError(e.getLocalizedMessage());
    }
  }
  
  @JRubyMethod(rest = true)
  public Object swap(final ThreadContext context, final IRubyObject[] args, final Block block) {
    ArraySeq seq = ArraySeq.create((Object[])args);
    Object arg0 = seq.get(0);
    Object arg1 = seq.get(1);
    
    try {
      return atom.swap(new ClojureFunction(context, block), arg0, arg1, seq.next().next());
    } catch (Exception e) {
      throw context.getRuntime().newConcurrencyError(e.getLocalizedMessage());
    }
  }
  
  @JRubyMethod(name = "compare_and_set")
  public IRubyObject compareAndSet(ThreadContext context, IRubyObject oldv, IRubyObject newv){
    return atom.compareAndSet(oldv, newv) ? context.getRuntime().getTrue() : context.getRuntime().getFalse();
  }
  
  @JRubyMethod
  public Object reset(final ThreadContext context, final IRubyObject newVal) {
    return atom.reset(newVal);
  }
  
  @JRubyMethod
  public Object deref(final ThreadContext context) {
    try {
      return atom.deref();
    } catch (Exception e) {
      throw context.getRuntime().newConcurrencyError(e.getLocalizedMessage());
    }
  }
  
}