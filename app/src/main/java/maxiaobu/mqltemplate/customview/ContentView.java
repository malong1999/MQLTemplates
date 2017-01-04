package maxiaobu.mqltemplate.customview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import maxiaobu.mqltemplate.R;

/**
 * Created by 马小布 on 2017/1/4：09:44.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：PagerTabsParallaxImageActivity  CollapsingPagerTitleAdapter
 * 伪码：
 * 待完成：
 */

public class ContentView  extends FrameLayout {
    public ContentView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_content, this);
    }
}
