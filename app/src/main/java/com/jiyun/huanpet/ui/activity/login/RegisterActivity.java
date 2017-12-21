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
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

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
    private UMAuthListener authListener;

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

        authListener = new UMAuthListener() {
            /**
             * @desc 授权开始的回调
             * @param platform 平台名称
             */
            @Override
            public void onStart(SHARE_MEDIA platform) {

            }

            /**
             * @desc 授权成功的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param data 用户资料返回
             */
            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
//                uid      QQ用户id
//                name     QQ用户昵称
//                gender   QQ用户性别
//                iconurl  QQ用户头像
                String uid = data.get("uid");
                String name = data.get("name");
                String gender = data.get("gender");
                String iconurl = data.get("iconurl");

//                Toast.makeText(RegisterActivity.this, "成功了", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(RegisterActivity.this, BindPhoneActivity.class);
                in.putExtra("uid",uid);
                in.putExtra("name",name);
                in.putExtra("gender",gender);
                in.putExtra("iconurl",iconurl);
                startActivity(in);
            }

            /**
             * @desc 授权失败的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param t 错误原因
             */
            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {

                Toast.makeText(RegisterActivity.this, "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();
            }

            /**
             * @desc 授权取消的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             */
            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText(RegisterActivity.this, "取消了", Toast.LENGTH_LONG).show();
            }
        };


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
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, authListener);

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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
