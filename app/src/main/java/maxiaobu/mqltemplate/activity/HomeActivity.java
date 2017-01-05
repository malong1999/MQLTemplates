package maxiaobu.mqltemplate.activity;

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
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.adapter.FrgViewPagerAdapter;
import maxiaobu.mqltemplate.base.BaseAty;
import maxiaobu.mqltemplate.fragment.MaterialFragment;
import maxiaobu.mqltemplate.fragment.PatternsFragment;
import maxiaobu.mqltemplate.weiget.nestedscroll.MyNestedScrollView;
import maxiaobu.mqltemplate.weiget.nestedscroll.WrapContentHeightViewPager;
import maxiaobu.mxbutilscodelibrary.BarUtils;

/**
 * Created by 马小布 on 2017/1/3.
 * introduction: 真他娘的不知道说点啥
 * email:maxiaobu1999@163.com
 * 功能：主界面
 * 伪码：
 * 待完成：
 */
public class HomeActivity extends BaseAty {


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
    private AccountHeader mHeaderResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initDrawer(savedInstanceState);
        initView();
        initData();
    }

    @Override
    public void initView() {
        BarUtils.setTranslucent(this);//设置statusBar半透明

        setSupportActionBar(mToolbar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -mHeadLayout.getHeight() / 2) {
                    mCollapsingToolbarLayout.setTitle("马小布");
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
                getWindow().getDecorView().getWindowVisibleDisplayFrame(rectangle);
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

    /**
     * 设置drawerlayout
     * @param savedInstanceState
     */
    private void initDrawer(Bundle savedInstanceState) {
        mHeaderResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false)
                .withHeaderBackground(R.mipmap.bg_drawer_header)
                .withSavedInstance(savedInstanceState)
                .build();
        new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(mHeaderResult)
                .withToolbar(mToolbar)
                .withFullscreen(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("home").withIcon(FontAwesome.Icon.faw_home).withIdentifier(1).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                Toast.makeText(mActivity,"home被点击",Toast.LENGTH_LONG).show();
                                return false;
                            }
                        }),
                        new PrimaryDrawerItem().withName("主题").withIcon(FontAwesome.Icon.faw_gamepad),
                        new SectionDrawerItem().withName("material控件"),
                        new SecondaryDrawerItem().withName("AppBar").withIcon(FontAwesome.Icon.faw_cog),
                        new SecondaryDrawerItem().withName("fab").withIcon(FontAwesome.Icon.faw_question).withEnabled(false),
                        new SecondaryDrawerItem().withName("snackbar").withIcon(FontAwesome.Icon.faw_github),
                        new SecondaryDrawerItem().withName("tabLayout").withIcon(FontAwesome.Icon.faw_bullhorn),
                        new SectionDrawerItem().withName("模板"),
                        new SecondaryDrawerItem().withName("登陆").withIcon(FontAwesome.Icon.faw_cog)
                )
                .withSavedInstance(savedInstanceState)
                .build();
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

    /**
     * 初始化viewpager
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        FrgViewPagerAdapter adapter = new FrgViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MaterialFragment(), "material");
        adapter.addFragment(new PatternsFragment(), "模版");
        viewPager.setAdapter(adapter);
    }

    public WrapContentHeightViewPager getViewPager() {
        return mViewpager;
    }

}
