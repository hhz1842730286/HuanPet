package com.jiyun.huanpet.ui.activity.login;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.RegisterContract;
import com.jiyun.huanpet.presenter.presenter.RegisterPresenterImpl;
import com.jiyun.huanpet.ui.base.BaseActivity;

/**
 * Created by mengYao on 2017/12/10.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenterImpl> implements View.OnClickListener,RegisterContract.RegisterView {

    private TextView mRegisterLogin;
    private TextView mRegisterBack;
    private TextView mGetCheckCode;
    private TextView mWxRegister;
    private TextView mQQRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void findViewById() {
        mRegisterBack = (TextView) findViewById(R.id.mRegisterBack);
        mRegisterLogin = (TextView) findViewById(R.id.mRegisterLogin);
        mGetCheckCode = (TextView) findViewById(R.id.mGetCheckCode);
        mWxRegister = (TextView) findViewById(R.id.mWxRegister);
        mQQRegister = (TextView) findViewById(R.id.mQQRegister);
    }

    @Override
    protected void init() {
        mRegisterBack.setOnClickListener(this);
        mRegisterLogin.setOnClickListener(this);
        mGetCheckCode.setOnClickListener(this);
        mWxRegister.setOnClickListener(this);
        mQQRegister.setOnClickListener(this);
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
            case R.id.mRegisterBack:
                finish();
                break;
            case R.id.mRegisterLogin:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
            case R.id.mGetCheckCode:
                Toast.makeText(this, "获取验证码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mWxRegister:
                startActivity(new Intent(this,BindPhoneActivity.class));
                break;
            case R.id.mQQRegister:
                startActivity(new Intent(this,BindPhoneActivity.class));
                break;
        }
    }
}
