package com.jiyun.huanpet.presenter.presenter;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.login.HomeLogin;
import com.jiyun.huanpet.model.biz.login.IHomeLogin;
import com.jiyun.huanpet.presenter.contract.PersonalInfomationContract;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;

/**
 * Created by mengYao on 2017/12/12.
 */

public class PersonalInfomationPresenterImpl implements PersonalInfomationContract.PersonalInfomationPresenter {
   private IHomeLogin iHomeLogin;
   private PersonalInfomationContract.PersonalInfomationView personalInfomationView;

    public PersonalInfomationPresenterImpl(PersonalInfomationContract.PersonalInfomationView personalInfomationView) {
        this.personalInfomationView = personalInfomationView;
        this.iHomeLogin = new HomeLogin();
    }

    @Override
    public void attchTo(PersonalInfomationContract.PersonalInfomationView personalInfomationView) {

    }

    @Override
    public void detach() {

    }

    @Override
    public void updataSex(String userId, String userSex) {
        iHomeLogin.updataSex(userId, userSex, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Gson gson = new Gson();
                ForgetPassWordBean forgetPassWordBean = gson.fromJson(string, ForgetPassWordBean.class);
                personalInfomationView.updatasex(forgetPassWordBean);
            }

            @Override
            public void error(String error) {

            }
        });
    }

    @Override
    public void updataSexMan(String userId, String userSex) {
        iHomeLogin.updataSex(userId, userSex, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Gson gson = new Gson();
                ForgetPassWordBean forgetPassWordBean = gson.fromJson(string, ForgetPassWordBean.class);
                personalInfomationView.updataSexMan(forgetPassWordBean);
            }

            @Override
            public void error(String error) {

            }
        });
    }

    @Override
    public void updataBirth(String userId, String birthDay) {
        iHomeLogin.updatabirth(userId, birthDay, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Gson gson = new Gson();
                ForgetPassWordBean forgetPassWordBean = gson.fromJson(string, ForgetPassWordBean.class);
                personalInfomationView.updataBirth(forgetPassWordBean);
            }

            @Override
            public void error(String error) {

            }
        });
    }

    @Override
    public void updataUserPhone(String userId, String userPhone) {
       iHomeLogin.updataUserPhone(userId, userPhone, new HttpCallback() {
           @Override
           public void success(Object o) {
               String string = o.toString();
           }

           @Override
           public void error(String error) {

           }
       });
    }
}
