package shopping_demo.com.fragmentdemo.struct;

/**
 * Created by ws on 18-5-9.
 */

public abstract class FunctionWithParamNoResult<Param> extends Function {

    public FunctionWithParamNoResult(String name) {
        super(name);
    }

    public abstract void invoke(Param param);
}
