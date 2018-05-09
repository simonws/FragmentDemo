package shopping_demo.com.fragmentdemo.struct;

/**
 * Created by ws on 18-5-9.
 */

public abstract class FunctionWithParamNoResult<Param> extends Function {
    private Param mParam;

    public FunctionWithParamNoResult(String name, Param param) {
        super(name);
        mParam = param;
    }

    abstract void invoke();
}
