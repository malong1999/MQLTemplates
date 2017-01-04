package maxiaobu.mqltemplate.activity.collapsing;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.base.BaseAty;
/**
 * Created by 马小布 on 2017/1/4.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：折叠+actionbar消失+下fab
 * 伪码：
 * 待完成：
 */
public class ScrollCollapseLargeToolbarActivity extends BaseAty {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.appbar)
    AppBarLayout mAppbar;
    @Bind(R.id.nested_scrollview)
    NestedScrollView mNestedScrollview;
    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.main_content)
    CoordinatorLayout mMainContent;

    /**
     * fab是否可见
     */
    private boolean mFabIsVisible = true;
    /**
     * fab从隐藏-》可见的位移
     */
    private int mFabTranslationSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_collapse_large_toolbar);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String toolbarTitle = "折叠+actionbar消失+下fab";
        mCollapsingToolbar.setTitle(toolbarTitle);

        mNestedScrollview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    animateFab(false);
                } else {
                    animateFab(true);
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    /**
     * 显示隐藏fab
     * @param show
     */
    private void animateFab(boolean show) {
        if (show && !mFabIsVisible) {
            //Show
            mFabIsVisible = true;
            mFab.animate().translationY(0);
        } else if (!show && mFabIsVisible) {
            //Hide
            mFabIsVisible = false;
            if (mFabTranslationSize == 0) {
                int margin = ((CoordinatorLayout.LayoutParams) mFab.getLayoutParams()).bottomMargin;
                mFabTranslationSize = mFab.getHeight() + margin * 2;
            }
            mFab.animate().translationY(mFabTranslationSize);
        }
    }
}
