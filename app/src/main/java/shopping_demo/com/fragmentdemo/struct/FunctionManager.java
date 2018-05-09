package shopping_demo.com.fragmentdemo.struct;


import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ws on 18-5-9.
 */

public class FunctionManager {
    private static final FunctionManager sInstance = new FunctionManager();

    public static FunctionManager getsInstance() {
        return sInstance;
    }

    private FunctionManager() {
        mFunctionNoParamNoResultMap = new HashMap<>();
    }

    Map<String, FunctionNoParamNoResult> mFunctionNoParamNoResultMap;


    public FunctionManager addFunction(FunctionNoParamNoResult functionNoParamNoResult) {
        if (!TextUtils.isEmpty(functionNoParamNoResult.mFunctionName)) {
            mFunctionNoParamNoResultMap.put(functionNoParamNoResult.mFunctionName, functionNoParamNoResult);
        }
        return this;
    }

    public void invokeFunction(String name) {
        mFunctionNoParamNoResultMap.get(name).invoke();
    }
}
