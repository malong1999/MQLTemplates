package maxiaobu.mqltemplate.fragment;


import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.adapter.FrgViewPagerAdapter;
import maxiaobu.mqltemplate.base.BaseFrg;
import maxiaobu.mqltemplate.weight.nestedscroll.MyNestedScrollView;
import maxiaobu.mqltemplate.weight.nestedscroll.WrapContentHeightViewPager;

/**
 * Created by 马小布 on 2017/1/3.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：主页
 * 伪码：
 * 待完成：
 */
public class HomeFragment extends BaseFrg {

    @Bind(R.id.head_iv)
    ImageView mHeadIv;
    @Bind(R.id.one)
    LinearLayout mOne;
    @Bind(R.id.two)
    LinearLayout mTwo;
    @Bind(R.id.head_layout)
    LinearLayout mHeadLayout;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @Bind(R.id.tabs)
    TabLayout mTabs;
    @Bind(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @Bind(R.id.viewpager)
      WrapContentHeightViewPager mViewpager;
    @Bind(R.id.nested_scroll_view)
    MyNestedScrollView mNestedScrollView;
    @Bind(R.id.container)
    CoordinatorLayout mContainer;
    private View mRootView;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, mRootView);
        initView();
        initData();
        return mRootView;
    }

    @Override
    public void initView() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -mHeadLayout.getHeight() / 2) {
                    mCollapsingToolbarLayout.setTitle("    马小布");
                } else {
                    mCollapsingToolbarLayout.setTitle(" ");
                }
            }
        });
        loadBlurAndSetStatusBar();
        if (mViewpager!=null)
            setupViewPager(mViewpager);
        mTabs.setupWithViewPager(mViewpager);//setupWithViePager必须在ViewPager.setAdapter()之后调用
        mViewpager.postDelayed(new Runnable() {
            @Override
            public void run() {
                Rect rectangle = new Rect();
                getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rectangle);
                Log.d("HomeFragment", "mToolbar.getHeight() + mTabs.getHeight() + rectangle.top:" + (mToolbar.getHeight() + mTabs.getHeight() + rectangle.top));
                mViewpager.setH(mToolbar.getHeight() + mTabs.getHeight() + rectangle.top);
                mViewpager.resetHeight(1);
                Log.d("HomeFragment", "mViewpager.getHeight():" + mViewpager.getHeight());
            }
        },200);

    }

    @Override
    public void initData() {

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 设置毛玻璃效果和沉浸状态栏
     */
    private void loadBlurAndSetStatusBar() {
        Glide.with(this).load(R.mipmap.test_bg).bitmapTransform(new BlurTransformation(mActivity, 50))
                .into(new SimpleTarget<GlideDrawable>() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super
                            GlideDrawable> glideAnimation) {
                        mHeadLayout.setBackground(resource);
                        mContainer.setBackground(resource);
                    }
                });

        Glide.with(this).load(R.mipmap.test_bg).bitmapTransform(new BlurTransformation(mActivity, 50))
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super
                            GlideDrawable> glideAnimation) {
                        mCollapsingToolbarLayout.setContentScrim(resource);
                    }
                });
    }

    private void setupViewPager(ViewPager viewPager) {
        FrgViewPagerAdapter adapter = new FrgViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new MaterialFragment(), "material");
        adapter.addFragment(new PatternsFragment(), "模版");
        viewPager.setAdapter(adapter);
    }

    public WrapContentHeightViewPager getViewpager(){
        return mViewpager;
    }

}
