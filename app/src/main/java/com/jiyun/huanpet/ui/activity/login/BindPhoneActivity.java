package com.jiyun.huanpet.ui.activity.login;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.BindPhoneContract;
import com.jiyun.huanpet.presenter.presenter.BindPhonePresenterImpl;
import com.jiyun.huanpet.ui.base.BaseActivity;

/**
 * Created by mengYao on 2017/12/11.
 */

public class BindPhoneActivity extends BaseActivity<BindPhonePresenterImpl> implements BindPhoneContract.BindPhoneView, View.OnClickListener {

    private ImageView mBindPhoneBack;
    private Button mBindPhoneBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    protected void findViewById() {
        mBindPhoneBack = (ImageView) findViewById(R.id.mBindPhoneBack);
        mBindPhoneBtn = (Button) findViewById(R.id.mBindPhoneBtn);
    }

    @Override
    protected void init() {
        mBindPhoneBack.setOnClickListener(this);
        mBindPhoneBtn.setOnClickListener(this);
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
            case R.id.mBindPhoneBack:
                finish();
                break;
            case R.id.mBindPhoneBtn:

                break;
        }
    }
}
