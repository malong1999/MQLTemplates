package maxiaobu.mqltemplate.activity.collapsing;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.base.BaseAty;

/**
 * Created by 马小布 on 2017/1/4.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：snackbar+fab
 * 伪码：
 * 待完成：
 */
public class CollapsingSnackbarActivity extends BaseAty {

    @Bind(R.id.fab)
    FloatingActionButton mFab;
    @Bind(R.id.main_content)
    CoordinatorLayout mMainContent;


    private Snackbar mSnackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_snackbar);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackbar(view,"fab被电击");
            }
        });

    }

    @Override
    public void initData() {

    }

    private void showSnackbar(View view, String message) {
        if (mSnackbar != null && mSnackbar.isShown()) {
            mSnackbar.dismiss();
            mSnackbar = null;
        } else {
            mSnackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
            mSnackbar.show();
        }
    }
}
