package shopping_demo.com.fragmentdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import shopping_demo.com.fragmentdemo.struct.FunctionManager;

/**
 * Created by ws on 18-5-9.
 */

public class BaseFragment extends Fragment {
    public FunctionManager functionanager;

    public void setFunctionManager(FunctionManager manager) {
        functionanager = manager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        activity.setFunction(getTag());
    }
}
