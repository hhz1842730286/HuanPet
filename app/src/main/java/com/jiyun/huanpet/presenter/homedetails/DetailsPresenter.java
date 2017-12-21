package com.jiyun.huanpet.presenter.homedetails;

import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.login.HomeLogin;
import com.jiyun.huanpet.model.biz.login.IHomeLogin;
import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.HomeDetailsBean;
import com.jiyun.huanpet.ui.base.BaseView;
import com.jiyun.huanpet.view.DetailsView;

/**
 * Created by lh on 2017/12/21.
 */

public class DetailsPresenter implements IDetailsPresenter, BasePresenter {
    private IHomeLogin iHomeLogin;
    private DetailsView detailsView;

    public DetailsPresenter(DetailsView detailsView) {
        this.detailsView = detailsView;
        this.iHomeLogin = new HomeLogin();
    }

    @Override
    public void details(String userId) {
        iHomeLogin.details(userId, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Gson gson = new Gson();
                HomeDetailsBean homeDetailsBean = gson.fromJson(string, HomeDetailsBean.class);
                detailsView.details(homeDetailsBean);
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
