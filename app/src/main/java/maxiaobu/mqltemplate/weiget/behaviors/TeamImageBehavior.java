package maxiaobu.mqltemplate.weiget.behaviors;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import maxiaobu.mqltemplate.R;

/**
 * Created by 马小布 on 2017/1/4.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：CustomBehaviorActivity 左右图片的behavior
 * 伪码：
 * 待完成：
 */
@SuppressWarnings("unused")
public class TeamImageBehavior extends CoordinatorLayout.Behavior<ImageView> {

    private final Context mContext;
    private int mToolbarHeight;
    private int mMaxScrollAppBar;
    private float mImageSizeToolbar;
    private float mImageSizeMax;

    /**
     * Constructor
     *
     * @param context Context
     * @param attrs   AttributeSet
     */
    public TeamImageBehavior(Context context, AttributeSet attrs) {
        mContext = context;
        init();
    }

    private void init() {
        mImageSizeToolbar = mContext.getResources().getDimensionPixelSize(R.dimen.custom_behavior_image_size_toolbar);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
        AppBarLayout appBarLayout = (AppBarLayout) dependency;
        shouldInitProperties(child, appBarLayout);

        int currentScroll = dependency.getBottom();
        if (currentScroll < mToolbarHeight) {
            currentScroll = mToolbarHeight;
        }
        float percentage = currentScroll * 100 / mMaxScrollAppBar;
        float currentImageDelta = percentage * (mImageSizeMax - mImageSizeToolbar) / 100;
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        params.width = (int) (mImageSizeToolbar + currentImageDelta);
        params.height = (int) (mImageSizeToolbar + currentImageDelta);
        child.setLayoutParams(params);
        return true;
    }

    private void shouldInitProperties(ImageView child, AppBarLayout appBarLayout) {
        if (mImageSizeMax == 0) {
            mImageSizeMax = child.getHeight();
        }
        if (mMaxScrollAppBar == 0) {
            mMaxScrollAppBar = appBarLayout.getTotalScrollRange();
        }
        if (mToolbarHeight == 0) {
            TypedArray styledAttributes = mContext.getTheme().obtainStyledAttributes(
                    new int[]{android.R.attr.actionBarSize});
            mToolbarHeight = (int) styledAttributes.getDimension(0, 0);
            styledAttributes.recycle();
        }
    }

}