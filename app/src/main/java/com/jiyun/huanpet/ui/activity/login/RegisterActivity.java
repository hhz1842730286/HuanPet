package com.jiyun.huanpet.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanpet.R;
import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.httputils.CJSON;
import com.jiyun.huanpet.presenter.contract.RegisterContract;
import com.jiyun.huanpet.presenter.presenter.RegisterPresenterImpl;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;
import com.jiyun.huanpet.ui.base.BaseActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mengYao on 2017/12/10.
 */

public class RegisterActivity extends BaseActivity<RegisterPresenterImpl> implements View.OnClickListener, RegisterContract.RegisterView {

    private TextView mRegisterLogin;
    private TextView mRegisterBack;
    private TextView mGetCheckCode;
    private TextView mWxRegister;
    private TextView mQQRegister;
    private Button mBtnRegister;
    private EditText editText;
    private EditText VerificationCode;
    private EditText Username;
    private EditText password;
    private RegisterContract.RegisterPresenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void findViewById() {
        mPresenter = new RegisterPresenterImpl(this);
        editText = (EditText) findViewById(R.id.editText);
        VerificationCode = (EditText) findViewById(R.id.VerificationCode);
        Username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.password);

        mRegisterBack = (TextView) findViewById(R.id.mRegisterBack);
        mRegisterLogin = (TextView) findViewById(R.id.mRegisterLogin);
        mGetCheckCode = (TextView) findViewById(R.id.mGetCheckCode);
        mWxRegister = (TextView) findViewById(R.id.mWxRegister);
        mQQRegister = (TextView) findViewById(R.id.mQQRegister);
        mBtnRegister = (Button) findViewById(R.id.mBtnRegister);



    }

    @Override
    protected void init() {
        mBtnRegister.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.mRegisterBack:
                finish();
                break;
            case R.id.mRegisterLogin:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.mGetCheckCode:
                Toast.makeText(this, "获取验证码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mWxRegister:
                startActivity(new Intent(this, BindPhoneActivity.class));
                break;
            case R.id.mQQRegister:
                startActivity(new Intent(this, BindPhoneActivity.class));
                break;
                case R.id.mBtnRegister:

                    String phoneNumber = editText.getText().toString().trim();
                    String username = Username.getText().toString().trim();
                    String pass= password.getText().toString().trim();
                    mPresenter.url(phoneNumber,username,pass);
                    break;
        }
    }


    @Override
    public void register(RegisterBean registerBean) {
        if(registerBean.isRet()==true){
            Toast.makeText(this, "注册成功,请登录", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "注册失败，请重新注册", Toast.LENGTH_SHORT).show();
        }

    }
}
