package maxiaobu.mqltemplate.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.base.BaseAty;
import maxiaobu.mqltemplate.fragment.HomeFragment;
import maxiaobu.mqltemplate.weight.nestedscroll.WrapContentHeightViewPager;
import maxiaobu.mxbutilscodelibrary.BarUtils;

public class HomeActivity extends BaseAty {


    @Bind(R.id.ly_container)
    FrameLayout mLyContainer;
    @Bind(R.id.container)
    RelativeLayout mContainer;
    private HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        mHomeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.ly_container, mHomeFragment).commit();
        BarUtils.setTranslucent(this);//设置statusBar半透明
    }

    @Override
    public void initData() {

    }

    public WrapContentHeightViewPager getViewPager() {
        return mHomeFragment.getViewpager();
    }

}
