package com.jiyun.huanpet.presenter.forget;

import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.login.HomeLogin;
import com.jiyun.huanpet.model.biz.login.IHomeLogin;
import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;
import com.jiyun.huanpet.ui.base.BaseView;
import com.jiyun.huanpet.view.ForgetView;

/**
 * Created by lh on 2017/12/21.
 */

public class ForgetPresenter implements IForgetPresenter, BasePresenter {
    private IHomeLogin iHomeLogin;
    private ForgetView forgetView;

    public ForgetPresenter(ForgetView forgetView) {
        this.forgetView = forgetView;
        this.iHomeLogin = new HomeLogin();
    }

    @Override
    public void forgetWord(String userPhone, String password) {
        iHomeLogin.forgetPassword(userPhone, password, new HttpCallback() {
            @Override
            public void success(Object o) {
                Gson gson = new Gson();
                String string = o.toString();
                ForgetPassWordBean forgetPassWordBean = gson.fromJson(string, ForgetPassWordBean.class);
                forgetView.forgetPassWord(forgetPassWordBean);
            }

            @Override
            public void error(String error) {

            }
        });
    }

    @Override
    public void attchTo(BaseView baseView) {

    }

    @Override
    public void detach() {

    }
}
