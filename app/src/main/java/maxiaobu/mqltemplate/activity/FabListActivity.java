package maxiaobu.mqltemplate.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import maxiaobu.mqltemplate.R;
import maxiaobu.mqltemplate.base.BaseAty;

public class FabListActivity extends BaseAty {

    @Bind(R.id.btn_list)
    Button mBtnList;
    @Bind(R.id.btn_menu)
    Button mBtnMenu;
    @Bind(R.id.btn_progress)
    Button mBtnProgress;
    @Bind(R.id.activity_fab_list)
    CoordinatorLayout mActivityFabList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
