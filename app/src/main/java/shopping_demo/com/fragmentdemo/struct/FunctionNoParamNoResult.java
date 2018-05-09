package shopping_demo.com.fragmentdemo.struct;

/**
 * Created by ws on 18-5-9.
 */

public abstract class FunctionNoParamNoResult extends Function {
    public FunctionNoParamNoResult(String name) {
        super(name);
    }

    abstract public void invoke();
}
