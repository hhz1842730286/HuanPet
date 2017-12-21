package com.jiyun.huanpet.presenter.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.login.HomeLogin;
import com.jiyun.huanpet.model.biz.login.IHomeLogin;
import com.jiyun.huanpet.presenter.contract.BindPhoneContract;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;

/**
 * Created by mengYao on 2017/12/11.
 */

public class BindPhonePresenterImpl implements BindPhoneContract.BindPhonePresenter{
    private IHomeLogin iHomeLogin;
    private BindPhoneContract.BindPhoneView bindPhoneView;

    public BindPhonePresenterImpl(BindPhoneContract.BindPhoneView bindPhoneView) {
        this.iHomeLogin = new HomeLogin();
        this.bindPhoneView = bindPhoneView;
    }

    @Override
    public void attchTo(BindPhoneContract.BindPhoneView bindPhoneView) {

    }

    @Override
    public void detach() {

    }

    @Override
    public void thirdregister(String userPhone, String userName, String password, String userImage, String threeId) {
        iHomeLogin.register(userPhone, userName, password, userImage, threeId, new HttpCallback() {
            @Override
            public void success(Object o) {
                Log.e("ooooooooooo",o.toString());
                String string = o.toString();
                Gson gson = new Gson();
                RegisterBean bean = gson.fromJson(string, RegisterBean.class);
                bindPhoneView.register(bean);
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
