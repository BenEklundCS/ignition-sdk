package com.inductiveautomation.ignition.examples.scripting;

import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.script.hints.ScriptArg;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunction;

public abstract class AbstractScriptModule implements MathBlackBox {

    static {
        BundleUtil.get().addBundle(
            AbstractScriptModule.class.getSimpleName(),
            AbstractScriptModule.class.getClassLoader(),
            AbstractScriptModule.class.getName().replace('.', '/')
        );
    }

    @Override
    @ScriptFunction(docBundlePrefix = "AbstractScriptModule")
    public int multiply(
        @ScriptArg("arg0") int arg0,
        @ScriptArg("arg1") int arg1) {

        return multiplyImpl(arg0, arg1);
    }
    public String helloWorld(){
        return "Hi there!";
    }
    public int fib(@ScriptArg("arg0") int arg0) {
        return (arg0 <= 1) ? (arg0) : (fib(arg0-1) + fib(arg0-2));
    }

    protected abstract int multiplyImpl(int arg0, int arg1);

}
