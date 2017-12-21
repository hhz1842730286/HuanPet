package com.jiyun.huanpet.ui.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.jiyun.huanpet.httputils.TokenUtil;
import com.jiyun.huanpet.presenter.contract.LoginContract;
import com.jiyun.huanpet.presenter.presenter.LoginPresenterImpl;
import com.jiyun.huanpet.ui.activity.home.activity.ForgetPassWordActivity;
import com.jiyun.huanpet.ui.activity.home.activity.HomeActivity;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;
import com.jiyun.huanpet.ui.base.BaseActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by mengYao on 2017/12/9.
 */

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginContract.LoginView, View.OnClickListener {

    private Button mBtnLogin;
    private TextView mToRegister;
    private LinearLayout mWxLogin;
    private LinearLayout mQqLogin;
    private ImageView mLoginBack,mQqLoginImg;
    private EditText mLoginPhoneEdit;
    private EditText mLoginPassWordEdit;
    private LoginPresenterImpl mPresenter;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private UMAuthListener authListener;
    private TextView mForgetWord;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViewById() {

        preferences = LoginActivity.this.getSharedPreferences("Login", MODE_PRIVATE);
        editor = preferences.edit();
        mPresenter = new LoginPresenterImpl(this);
        mForgetWord = (TextView) findViewById(R.id.mForgetWord);
        mLoginPhoneEdit = (EditText) findViewById(R.id.mLoginPhoneEdit);
        mLoginPassWordEdit = (EditText) findViewById(R.id.mLoginPassWordEdit);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);
        mToRegister = (TextView) findViewById(R.id.mToRegister);
        mWxLogin = (LinearLayout) findViewById(R.id.mWxLogin);
        mQqLogin = (LinearLayout) findViewById(R.id.mQqLogin);
        mQqLoginImg = (ImageView) findViewById(R.id.mQqLoginImg);
        mLoginBack = (ImageView) findViewById(R.id.mLoginBack);
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

//                Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_SHORT).show();
                String uid = data.get("uid");
                mPresenter.thierdlogin(uid);
            }

            /**
             * @desc 授权失败的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param t 错误原因
             */
            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {

                Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();
            }

            /**
             * @desc 授权取消的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             */
            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
            }
        };

    }

    @Override
    protected void init() {
        mForgetWord.setOnClickListener(this);
        mQqLoginImg.setOnClickListener(this);
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
            case R.id.mForgetWord:
                 Intent in = new Intent(this, ForgetPassWordActivity.class);
                  startActivity(in);
                break;
            case R.id.mBtnLogin:
                TokenUtil.setToken();
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
            case R.id.mQqLoginImg:
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, authListener);
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
            Log.e("registerBean",userName);
            String userId = registerBean.getResult().getUserId();
            String userImage = registerBean.getResult().getUserImage();
            int userSex = registerBean.getResult().getUserSex();
            long userPhone = registerBean.getResult().getUserPhone();
            editor.putLong("userPhone",userPhone);
            editor.putString("userImage",userImage);
            editor.putString("userName",userName);
            editor.putString("userId",userId);
            editor.putInt("userSex",userSex);
            editor.commit();
            finish();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }

    //回调请求

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
