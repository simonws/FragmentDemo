package shopping_demo.com.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <p/>
 */
public class Fragment1 extends BaseFragment {
    private static final String TAG = "Fragment1";
    public static String INTERFACE_NAME = Fragment1.class.getName() + "nn";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.common_fragment_item_layout, null);
        viewGroup.findViewById(R.id.fragment_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                functionanager.invokeFunction(INTERFACE_NAME);
            }
        });

        return viewGroup;
    }
}
