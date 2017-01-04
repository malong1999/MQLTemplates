package maxiaobu.mqltemplate.activity.collapsing;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.adapter.CollapsingPagerTitleAdapter;
import maxiaobu.mqltemplate.base.BaseAty;

/**
 * Created by 马小布 on 2017/1/4.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：tablayout保留+actionbar消失
 * 伪码：
 * 待完成：
 */
public class CollapsingPagerTabsActivity extends BaseAty {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.pager_tabs)
    TabLayout mPagerTabs;
    @Bind(R.id.pager)
    ViewPager mPager;
    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.main_content)
    CoordinatorLayout mMainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_pager_tabs);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        CollapsingPagerTitleAdapter pagerAdapter = new CollapsingPagerTitleAdapter(this);
        pager.setAdapter(pagerAdapter);
        mPagerTabs.setupWithViewPager(pager);
    }

    @Override
    public void initData() {

    }
}
