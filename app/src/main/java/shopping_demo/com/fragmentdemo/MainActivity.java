package shopping_demo.com.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import shopping_demo.com.fragmentdemo.struct.FunctionManager;
import shopping_demo.com.fragmentdemo.struct.FunctionNoParamNoResult;
import shopping_demo.com.fragmentdemo.struct.FunctionWithParamNoResult;

/**
 * Created by ws on 17-9-20.
 */

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private static final String TAG = "MainActivity";
    private int mCurrentRadioIndex = 0;
    private RadioButton mLeftRadioBtn;
    private RadioButton mRightRadioBtn;
    private String[] mFragmentClassesArray = new String[]{Fragment1.class.getName(),
        Fragment2.class.getName()};
    private List<Fragment> mFragmentList;
    private RadioGroup mTabBarRadio;
    private int RECEIVE_MSG_TAG = 0;
    private int SEND_MSG_TAG = 1;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.common_two_item_fragment_layout);
        initStoryMsgView();
    }


    private void initStoryMsgView() {
        findViewById(R.id.fragment_two_item_layout).setVisibility(View.VISIBLE);
        mLeftRadioBtn = (RadioButton) findViewById(R.id.left_tab_btn);
        mLeftRadioBtn.setTag(RECEIVE_MSG_TAG);
        mRightRadioBtn = (RadioButton) findViewById(R.id.right_tab_btn);
        mRightRadioBtn.setTag(SEND_MSG_TAG);
        initFragment();

        mTabBarRadio = (RadioGroup) findViewById(R.id.tab_radio);
        mViewPager = ((ViewPager) findViewById(R.id.view_pager));
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragmentList.get(i);
            }

            @Override
            public int getCount() {
                return mFragmentClassesArray.length;
            }
        });

        mTabBarRadio.setOnCheckedChangeListener(this);
    }

    private void initFragment() {
        mFragmentList = new ArrayList<Fragment>(2);
        initFunctionManager();
        Fragment1 receiveStoryMsgFragment = (Fragment1) Fragment
            .instantiate(this, mFragmentClassesArray[0], null);
        receiveStoryMsgFragment.setFunctionManager(FunctionManager.getsInstance());

        Fragment2 sendStoryMsgFragment = (Fragment2) Fragment
            .instantiate(this, mFragmentClassesArray[1], null);
        sendStoryMsgFragment.setFunctionManager(FunctionManager.getsInstance());
        mFragmentList.add(receiveStoryMsgFragment);
        mFragmentList.add(sendStoryMsgFragment);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton radioButton = (RadioButton) findViewById(checkedId);
        mCurrentRadioIndex = (int) radioButton.getTag();
        mViewPager.setCurrentItem(mCurrentRadioIndex);
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (i == 0) {
            mTabBarRadio.check(R.id.left_tab_btn);
        } else {
            mTabBarRadio.check(R.id.right_tab_btn);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public void initFunctionManager() {
        FunctionManager functionManager = FunctionManager.getsInstance();
        functionManager.addFunction(new FunctionNoParamNoResult(Fragment1.INTERFACE_NN_NAME) {
            @Override
            public void invoke() {
                Toast.makeText(MainActivity.this, "无参数接口执行", Toast.LENGTH_SHORT).show();
            }
        }).addFunction(new FunctionWithParamNoResult<String>(Fragment1.INTERFACE_NY_NAME) {

            @Override
            public void invoke(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
