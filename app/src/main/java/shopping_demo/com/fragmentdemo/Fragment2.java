package shopping_demo.com.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ws on 18-5-9.
 */

public class Fragment2 extends BaseFragment {

    private static final String TAG = "Fragment2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.common_fragment_item_layout, null);
        ((Button) viewGroup.findViewById(R.id.fragment_btn)).setText("Fragment2");
        return viewGroup;
    }
}
