package com.jiyun.huanpet.ui.activity.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.presenter.contract.LoginContract;
import com.jiyun.huanpet.presenter.presenter.LoginPresenterImpl;
import com.jiyun.huanpet.ui.activity.home.activity.HomeActivity;
import com.jiyun.huanpet.ui.base.BaseActivity;

/**
 * Created by mengYao on 2017/12/9.
 */

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginContract.LoginView, View.OnClickListener {

    private Button mBtnLogin;
    private TextView mToRegister;
    private LinearLayout mWxLogin;
    private LinearLayout mQqLogin;
    private ImageView mLoginBack;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViewById() {
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);
        mToRegister = (TextView) findViewById(R.id.mToRegister);
        mWxLogin = (LinearLayout) findViewById(R.id.mWxLogin);
        mQqLogin = (LinearLayout) findViewById(R.id.mQqLogin);
        mLoginBack = (ImageView) findViewById(R.id.mLoginBack);
    }

    @Override
    protected void init() {
        mBtnLogin.setOnClickListener(this);
        mToRegister.setOnClickListener(this);
        mWxLogin.setOnClickListener(this);
        mQqLogin.setOnClickListener(this);
        mLoginBack.setOnClickListener(this);
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
            case R.id.mBtnLogin:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
            case R.id.mToRegister:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.mWxLogin:
                startActivity(new Intent(this,BindPhoneActivity.class));
                break;
            case R.id.mQqLogin:
                startActivity(new Intent(this,BindPhoneActivity.class));
                break;
            case R.id.mLoginBack:
                finish();
                break;
        }
    }
}
