package com.jiyun.huanpet.presenter.presenter;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.register.RegisterIHome;
import com.jiyun.huanpet.model.biz.register.RegisterHome;
import com.jiyun.huanpet.presenter.contract.RegisterContract;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;

/**
 * Created by mengYao on 2017/12/10.
 */

public class RegisterPresenterImpl implements RegisterContract.RegisterPresenter {
    private RegisterIHome registerIHome;
    private RegisterContract.RegisterView registerView;

    public RegisterPresenterImpl(RegisterContract.RegisterView registerView) {
        this.registerIHome = new RegisterHome();
        this.registerView = registerView;
    }

    @Override
    public void attchTo(RegisterContract.RegisterView registerView) {

    }

    @Override
    public void detach() {

    }


    @Override
    public void url(String phone, String user, String pass) {
        registerIHome.register(phone, user, pass, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Gson gson = new Gson();
                RegisterBean bean = gson.fromJson(string, RegisterBean.class);
                registerView.register(bean);
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
