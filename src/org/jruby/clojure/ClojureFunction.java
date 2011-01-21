package org.jruby.clojure;

import org.jruby.Ruby;
import org.jruby.runtime.Block;
import org.jruby.runtime.ThreadContext;
import clojure.lang.IFn;
import clojure.lang.ISeq;
import clojure.lang.RT;
import org.jruby.javasupport.JavaUtil;

public class ClojureFunction implements IFn {

  final Block block;
  final Ruby ruby;

  public ClojureFunction(final ThreadContext context, final Block block) {
    this.block = block;
    this.ruby = context.getRuntime();
  }

  @Override
  public Object call() throws Exception {
    return invoke();
  }

  public void run() {
    try {
      invoke();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  public Object invoke() throws Exception {
    return block.call(ruby.getCurrentContext());
  }

  public Object invoke(Object arg1) throws Exception {
    return block.call(ruby.getCurrentContext(),
      JavaUtil.convertJavaToRuby(ruby,arg1)
    );
  }

  public Object invoke(Object arg1, Object arg2) throws Exception {
    return block.call(ruby.getCurrentContext(),
      JavaUtil.convertJavaToRuby(ruby,arg1),
      JavaUtil.convertJavaToRuby(ruby,arg2)
    );
  }

  public Object invoke(Object arg1, Object arg2, Object arg3) throws Exception {
    return block.call(ruby.getCurrentContext(),
      JavaUtil.convertJavaToRuby(ruby,arg1),
      JavaUtil.convertJavaToRuby(ruby,arg2),
      JavaUtil.convertJavaToRuby(ruby,arg3)
    );
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7)
                      throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14)
                      throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13, arg14
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                      Object arg15) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13, arg14,
      arg15
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                      Object arg15, Object arg16) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13, arg14,
      arg15, arg16
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                      Object arg15, Object arg16, Object arg17) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13, arg14,
      arg15, arg16, arg17
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                      Object arg15, Object arg16, Object arg17, Object arg18) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13, arg14,
      arg15, arg16, arg17, arg18
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                      Object arg15, Object arg16, Object arg17, Object arg18, Object arg19) throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13, arg14,
      arg15, arg16, arg17, arg18, arg19
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                      Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20)
                      throws Exception {
    Object[] args = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13, arg14,
      arg15, arg16, arg17, arg18, arg19, arg20
    };
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, args));
  }

  public Object invoke(Object arg1, Object arg2, Object arg3, Object arg4, Object arg5, Object arg6, Object arg7,
                      Object arg8, Object arg9, Object arg10, Object arg11, Object arg12, Object arg13, Object arg14,
                      Object arg15, Object arg16, Object arg17, Object arg18, Object arg19, Object arg20,
                      Object... args) throws Exception {
    Object[] args1 = {
      arg1, arg2, arg3, arg4, arg5, arg6, arg7,
      arg8, arg9, arg10, arg11, arg12, arg13, arg14,
      arg15, arg16, arg17, arg18, arg19, arg20
    };
    
    Object[] conArgs = new Object[args1.length+args.length];
    System.arraycopy(args1, 0, conArgs, 0, args1.length);
    System.arraycopy(args, 0, conArgs, 0, args.length);
    
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby,conArgs));
  }
  
  @Override
  public Object applyTo(final ISeq arglist) throws Exception{
    return block.call(ruby.getCurrentContext(), JavaUtil.convertJavaArrayToRuby(ruby, RT.seqToArray(arglist)));
  }
}