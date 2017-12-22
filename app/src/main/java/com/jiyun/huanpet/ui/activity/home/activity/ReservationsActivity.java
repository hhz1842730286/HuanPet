package com.jiyun.huanpet.ui.activity.home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.ReservationsContract;
import com.jiyun.huanpet.ui.base.BaseActivity;

public class ReservationsActivity extends BaseActivity<ReservationsContract.ReservationsPresenter> implements ReservationsContract.ReservationsView{


    @Override
    protected int getLayoutId() {
        return R.layout.activity_reservations;
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void init() {

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
    public void register() {

    }
}
