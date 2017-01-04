package maxiaobu.mqltemplate.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import maxiaobu.mqltemplate.customview.ContentView;

/**
 * Created by 马小布 on 2017/1/4：09:41.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：PagerTabsParallaxImageActivity
 * 伪码：
 * 待完成：
 */
public class CollapsingPagerTitleAdapter extends PagerAdapter{

    private static final String PAGE = "Page ";

    private Context mContext;

    public CollapsingPagerTitleAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ContentView contentView = new ContentView(mContext);
        container.addView(contentView);
        return contentView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return PAGE + (position + 1);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
