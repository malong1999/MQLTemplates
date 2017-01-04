package maxiaobu.mqltemplate.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.OnClick;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.activity.patterns.BannersActivity;
import maxiaobu.mqltemplate.base.BaseFrg;

/**
 * Created by 马小布 on 2017/1/3.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：android场景模版列表
 * 伪码：
 * 待完成：
 */
public class PatternsFragment extends BaseFrg implements View.OnClickListener{

    private View mRootView;

    public PatternsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_patterns, container, false);
        initView();
        initData();
        return mRootView;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_banner})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_banner:
                startActivity(new Intent(mActivity, BannersActivity.class));
                break;
            default:
                break;
        }

    }
}
