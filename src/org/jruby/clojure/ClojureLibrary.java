package org.jruby.clojure;

import clojure.lang.IPersistentVector;
import clojure.lang.LockingTransaction;
import clojure.lang.PersistentVector;
import clojure.lang.Ref;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.RubyObject;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.Block;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.runtime.load.Library;

public class ClojureLibrary implements Library{
    public void load(Ruby runtime, boolean wrap) throws IOException {
        RubyModule cljModule = runtime.defineModule("Clojure");
        runtime.defineClassUnder("Object", runtime.getObject(), new ClojureObjectAllocator(), cljModule);

        runtime.getKernel().defineAnnotatedMethods(ClojureDosync.class);
        ClojureAgent.createAgentClass(runtime);
        ClojureAtom.createAtomClass(runtime);
    }

    public static class ClojureObjectAllocator implements ObjectAllocator {
        public IRubyObject allocate(Ruby runtime, RubyClass klazz) {
            return new ClojureObject(runtime, klazz);
        }
    }

    public static class ClojureObject extends RubyObject {
        public ClojureObject(Ruby runtime, RubyClass klass) {
            super(runtime, klass);
            try {
                variableTable = new Ref(PersistentVector.EMPTY);
            } catch (Exception e) {
                throw runtime.newConcurrencyError(e.getLocalizedMessage());
            }
        }

        @Override
        public Object getVariable(int index) {
            return ((IPersistentVector)variableTable.deref()).nth(index);
        }

        @Override
        public void setVariable(int index, Object value) {
            try {
                variableTable.set(((IPersistentVector)variableTable.deref()).assocN(index, value));
            } catch (IllegalStateException ise) {
                throw getRuntime().newConcurrencyError(ise.getLocalizedMessage());
            }
        }

        private final Ref variableTable;
    }

    public static class ClojureDosync {
        @JRubyMethod
        public static IRubyObject dosync(final ThreadContext context, final IRubyObject self, final Block block) {
            final Ruby ruby = context.getRuntime();
            try {
                return (IRubyObject)LockingTransaction.runInTransaction(new Callable() {
                    public Object call() throws Exception {
                        // re-get transaction in case this gets run in different threads
                        return block.call(ruby.getCurrentContext());
                    }
                });
            } catch (Exception e) {
                throw ruby.newConcurrencyError(e.getLocalizedMessage());
            }
        }
    }
}
