package maxiaobu.mqltemplate.activity.collapsing;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.base.BaseAty;

/**
 * Created by 马小布 on 2017/1/4.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：自定义行为
 * 伪码：
 * 待完成：
 */
public class CustomBehaviorActivity extends BaseAty implements AppBarLayout.OnOffsetChangedListener {

    @Bind(R.id.collapsing_toolbar_content)
    LinearLayout mCollapsingToolbarContent;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @Bind(R.id.appbar)
    AppBarLayout mAppbar;
    @Bind(R.id.activity_custom_behavior_header)
    FrameLayout mActivityCustomBehaviorHeader;
    @Bind(R.id.custom_behavior_image_teamA)
    ImageView mCustomBehaviorImageTeamA;
    @Bind(R.id.custom_behavior_image_teamB)
    ImageView mCustomBehaviorImageTeamB;
    @Bind(R.id.custom_behavior_score)
    TextView mCustomBehaviorScore;
    @Bind(R.id.main_content)
    CoordinatorLayout mMainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_behavior);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        mAppbar.addOnOffsetChangedListener(this);

        mCustomBehaviorImageTeamA.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);//右侧动图换颜色
    }

    @Override
    public void initData() {

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(verticalOffset) /
                (float) (maxScroll - mActivityCustomBehaviorHeader.getHeight());
        mActivityCustomBehaviorHeader.setAlpha(percentage);
    }
}
