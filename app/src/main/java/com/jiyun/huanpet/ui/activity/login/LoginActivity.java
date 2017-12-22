package com.jiyun.huanpet.ui.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.jiyun.huanpet.R;
import com.jiyun.huanpet.httputils.FileUtil;
import com.jiyun.huanpet.presenter.contract.LoginContract;
import com.jiyun.huanpet.presenter.presenter.LoginPresenterImpl;
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
                FileUtil.saveToken();
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

            editor.clear();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            String userName = registerBean.getResult().getUserName();
            Log.e("registerBean",userName);
            String userId = registerBean.getResult().getUserId();
            int userSex = registerBean.getResult().getUserSex();
            long userPhone = registerBean.getResult().getUserPhone();
            String password = registerBean.getResult().getPassword();
            //环信登录
            EMClient.getInstance().login(userName,password,new EMCallBack() {//回调
                @Override
                public void onSuccess() {
                    EMClient.getInstance().groupManager().loadAllGroups();
                    EMClient.getInstance().chatManager().loadAllConversations();
                    Log.e("main", "登录聊天服务器成功！");

                }

                @Override
                public void onProgress(int progress, String status) {

                }

                @Override
                public void onError(int code, String message) {
                    Log.e("main", "登录聊天服务器失败！");
                }
            });

            editor.putLong("userPhone",userPhone);
            editor.putString("userName",userName);
            editor.putString("userId",userId);
            editor.putInt("userSex",userSex);
            editor.putString("password",password);
            editor.commit();
            finish();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
}
