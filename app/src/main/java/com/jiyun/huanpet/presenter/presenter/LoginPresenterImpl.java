package com.jiyun.huanpet.presenter.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.login.HomeLogin;
import com.jiyun.huanpet.model.biz.login.IHomeLogin;
import com.jiyun.huanpet.presenter.contract.LoginContract;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;

/**
 * Created by mengYao on 2017/12/9.
 */

public class LoginPresenterImpl implements LoginContract.LoginPresenter {
     private IHomeLogin iHomeLogin;
     private LoginContract.LoginView loginView;
    public LoginPresenterImpl(LoginContract.LoginView loginView) {
        this.iHomeLogin = new HomeLogin();
        this.loginView = loginView;
    }

    @Override
    public void attchTo(LoginContract.LoginView loginView) {

    }

    @Override
    public void detach() {

    }

    @Override
    public void url(String user, String pass) {
       iHomeLogin.login(user, pass, new HttpCallback() {
           @Override
           public void success(Object o) {
               String string = o.toString();
               Gson gson = new Gson();
               RegisterBean bean = gson.fromJson(string, RegisterBean.class);
               loginView.login(bean);
           }

           @Override
           public void error(String error) {

           }
       });
    }

    @Override
    public void thierdlogin(String id) {
        iHomeLogin.thirdLogin(id, new HttpCallback() {
            @Override
            public void success(Object o) {
             Gson gson = new Gson();
                String string = o.toString();
                RegisterBean bean = gson.fromJson(string, RegisterBean.class);
                loginView.login(bean);
            }

            @Override
            public void error(String error) {

            }
        });
    }


}
