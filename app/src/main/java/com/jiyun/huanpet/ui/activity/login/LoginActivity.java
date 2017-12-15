package com.jiyun.huanpet.ui.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.constants.Constants;
import com.jiyun.huanpet.httputils.Md5Encrypt;
import com.jiyun.huanpet.presenter.contract.LoginContract;
import com.jiyun.huanpet.presenter.presenter.LoginPresenterImpl;
import com.jiyun.huanpet.ui.activity.home.activity.HomeActivity;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;
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
    private EditText mLoginPhoneEdit;
    private EditText mLoginPassWordEdit;
    private LoginPresenterImpl mPresenter;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViewById() {
        preferences = LoginActivity.this.getSharedPreferences("Login", MODE_PRIVATE);
        editor = preferences.edit();
        mPresenter = new LoginPresenterImpl(this);
        mLoginPhoneEdit = (EditText) findViewById(R.id.mLoginPhoneEdit);
        mLoginPassWordEdit = (EditText) findViewById(R.id.mLoginPassWordEdit);
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
        switch (v.getId()) {
            case R.id.mBtnLogin:
                String user = mLoginPhoneEdit.getText().toString().trim();
                String word = mLoginPassWordEdit.getText().toString().trim();
//                String s = Md5Encrypt.md5(word, "UTF-8");
                mPresenter.url(user, word);


                break;
            case R.id.mToRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.mWxLogin:
                startActivity(new Intent(this, BindPhoneActivity.class));
                break;
            case R.id.mQqLogin:
                startActivity(new Intent(this, BindPhoneActivity.class));
                break;
            case R.id.mLoginBack:
                finish();
                break;
        }
    }


    @Override
    public void login(RegisterBean registerBean) {
        if (registerBean.isRet() == true) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            String userName = registerBean.getResult().getUserName();
            String userId = registerBean.getResult().getUserId();
            int userSex = registerBean.getResult().getUserSex();
            long userPhone = registerBean.getResult().getUserPhone();
            editor.putLong("userPhone",userPhone);
            editor.putString("userName",userName);
            editor.putString("userId",userId);
            editor.putInt("userSex",userSex);
            editor.commit();
            Intent in = new Intent();
            in.putExtra("userPhone",userPhone);
            in.putExtra("userName",userName);
            in.putExtra("userId",userId);
            in.putExtra("userSex",userSex);
            setResult(Constants.RESULTCODE,in);
            finish();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
}
