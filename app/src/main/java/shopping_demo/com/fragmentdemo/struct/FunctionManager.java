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
        mFunctionWithParamNoResultMap = new HashMap<>();
    }

    private Map<String, FunctionNoParamNoResult> mFunctionNoParamNoResultMap;
    private Map<String, FunctionWithParamNoResult> mFunctionWithParamNoResultMap;


    public FunctionManager addFunction(FunctionNoParamNoResult functionNoParamNoResult) {
        if (!TextUtils.isEmpty(functionNoParamNoResult.mFunctionName)) {
            mFunctionNoParamNoResultMap.put(functionNoParamNoResult.mFunctionName, functionNoParamNoResult);
        }
        return this;
    }

    public FunctionManager addFunction(FunctionWithParamNoResult functionNoParamNoResult) {
        if (!TextUtils.isEmpty(functionNoParamNoResult.mFunctionName)) {
            mFunctionWithParamNoResultMap.put(functionNoParamNoResult.mFunctionName, functionNoParamNoResult);
        }
        return this;
    }

    public void invokeNNFun(String name) {
        mFunctionNoParamNoResultMap.get(name).invoke();
    }

    public <T> void invokeParamNoResultFun(String name, T param) {
        mFunctionWithParamNoResultMap.get(name).invoke(param);
    }

}
