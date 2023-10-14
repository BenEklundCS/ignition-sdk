// https://files.inductiveautomation.com/sdk/javadoc/ignition81/8.1.32
package com.inductiveautomation.ignition.examples.scripting; // built-in package for scripting
import com.inductiveautomation.ignition.common.BundleUtil; // needed for getResource*() calls // 
import com.inductiveautomation.ignition.common.script.hints.ScriptArg; // script hints for functions
import com.inductiveautomation.ignition.common.script.hints.ScriptFunction; // script hints for functions
 
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
