package maxiaobu.mqltemplate.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.activity.HomeActivity;
import maxiaobu.mqltemplate.base.BaseFrg;

/**
 * Created by 马小布 on 2017/1/3.
 * introduction：我长得真他娘的磕碜，单身未娶，求包养
 * email：maxiaobu1216@gmail.com
 * 功能：material特性列表
 * 伪码：
 * 待完成：
 */
public class MaterialFragment extends BaseFrg {


    private View mRootView;

    public MaterialFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_material, container, false);
        initView();
        initData();
        return mRootView;
    }

    @Override
    public void initView() {
        ((HomeActivity)getActivity()).getViewPager().setObjectForPosition(mRootView,0);

    }

    @Override
    public void initData() {

    }

}
