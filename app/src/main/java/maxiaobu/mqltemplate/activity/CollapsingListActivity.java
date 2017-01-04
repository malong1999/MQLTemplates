package maxiaobu.mqltemplate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.activity.collapsing.CollapseLargeToolbarActivity;
import maxiaobu.mqltemplate.activity.collapsing.CollapsingPagerTabsActivity;
import maxiaobu.mqltemplate.activity.collapsing.CollapsingSnackbarActivity;
import maxiaobu.mqltemplate.activity.collapsing.CustomBehaviorActivity;
import maxiaobu.mqltemplate.activity.collapsing.PagerTabsParallaxImageActivity;
import maxiaobu.mqltemplate.activity.collapsing.ParallaxImageToolbarActivity;
import maxiaobu.mqltemplate.activity.collapsing.ScrollCollapseLargeToolbarActivity;
import maxiaobu.mqltemplate.activity.collapsing.ScrollToolbarActivity;
import maxiaobu.mqltemplate.base.BaseAty;
/**
 * Created by 马小布 on 2017/1/4.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：appbar列表
 * 伪码：
 * 待完成：
 */
public class CollapsingListActivity extends BaseAty implements View.OnClickListener {

    @Bind(R.id.scroll_toolbar)
    TextView mScrollToolbar;
    @Bind(R.id.collapse_large_toolbar)
    TextView mCollapseLargeToolbar;
    @Bind(R.id.scroll_collapse_large_toolbar)
    TextView mScrollCollapseLargeToolbar;
    @Bind(R.id.parallax_image_toolbar)
    TextView mParallaxImageToolbar;
    @Bind(R.id.custom_behavior)
    TextView mCustomBehavior;
    @Bind(R.id.snackbar)
    TextView mSnackbar;
    @Bind(R.id.pager_tabs)
    TextView mPagerTabs;
    @Bind(R.id.pager_tabs_fixed_image)
    TextView mPagerTabsFixedImage;
    @Bind(R.id.activity_collapsing_list)
    ScrollView mActivityCollapsingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.pager_tabs_fixed_image, R.id.scroll_toolbar, R.id.collapse_large_toolbar
            , R.id.scroll_collapse_large_toolbar, R.id.parallax_image_toolbar, R.id.custom_behavior
            , R.id.snackbar, R.id.pager_tabs})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pager_tabs_fixed_image:
                startActivity(new Intent(CollapsingListActivity.this, PagerTabsParallaxImageActivity.class));
                break;
            case R.id.scroll_toolbar:
                startActivity(new Intent(mActivity, ScrollToolbarActivity.class));
                break;
            case R.id.collapse_large_toolbar:
                startActivity(new Intent(mActivity, CollapseLargeToolbarActivity.class));
                break;
            case R.id.scroll_collapse_large_toolbar:
                startActivity(new Intent(mActivity, ScrollCollapseLargeToolbarActivity.class));
                break;
            //iv折叠+上fab
            case R.id.parallax_image_toolbar:
                startActivity(new Intent(mActivity, ParallaxImageToolbarActivity.class));
                break;
            //自定义行为
            case R.id.custom_behavior:
                startActivity(new Intent(mActivity, CustomBehaviorActivity.class));
                break;
            //snackbar+fab
            case R.id.snackbar:
                startActivity(new Intent(mActivity, CollapsingSnackbarActivity.class));
                break;
            //tablayout保留+actionbar消失
            case R.id.pager_tabs:
                startActivity(new Intent(mActivity, CollapsingPagerTabsActivity.class));
                break;
            default:
                break;

        }

    }
}
