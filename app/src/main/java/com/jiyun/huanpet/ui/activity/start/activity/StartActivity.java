package com.jiyun.huanpet.ui.activity.start.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.StartPageContract;
import com.jiyun.huanpet.presenter.presenter.StartPagePresenterImpl;
import com.jiyun.huanpet.ui.activity.home.activity.HomeActivity;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.jiyun.huanpet.utils.BarUtils;

public class StartActivity extends BaseActivity<StartPagePresenterImpl> implements StartPageContract.StartPageView, View.OnClickListener {

    private Button mBtnStart;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void findViewById() {
        mBtnStart = (Button) findViewById(R.id.mBtnStart);
    }

    @Override
    protected void init() {
        mBtnStart.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void openProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBtnStart:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
    }
}
