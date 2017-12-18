package com.jiyun.huanpet.presenter.presenter;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.login.HomeLogin;
import com.jiyun.huanpet.model.biz.login.IHomeLogin;
import com.jiyun.huanpet.presenter.contract.HomeContract;
import com.jiyun.huanpet.ui.activity.home.bean.FuJinBean;
import com.jiyun.huanpet.ui.activity.home.bean.PetTypeBean;

import java.util.List;

/**
 * Created by mengYao on 2017/12/9.
 */

public class HomePresenterImpl implements HomeContract.HomePresenter {
    private IHomeLogin iHomeLogin;
    private HomeContract.HomeView homeView;

    public HomePresenterImpl(HomeContract.HomeView homeView) {
        this.iHomeLogin = new HomeLogin();
        this.homeView = homeView;
    }

    @Override
    public void attchTo(HomeContract.HomeView homeView) {

    }

    @Override
    public void detach() {

    }
    @Override
    public void fujinurl(final String beginIndex, String coordX, String coordY, String endIndex, String orderBy) {
        iHomeLogin.fujin(beginIndex, coordX, coordY, endIndex, orderBy, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Gson gson = new Gson();
                FuJinBean fuJinBean = gson.fromJson(string, FuJinBean.class);
                homeView.fujinview(fuJinBean.getDesc());

            }

            @Override
            public void error(String error) {

            }
        });
    }

    @Override
    public void petType(String beginIndex, String endIndex, String petTypeCode) {
      iHomeLogin.petType(beginIndex, endIndex, petTypeCode, new HttpCallback() {
          @Override
          public void success(Object o) {
              String string = o.toString();
              Gson gson = new Gson();
              PetTypeBean petTypeBean = gson.fromJson(string, PetTypeBean.class);
              homeView.petType(petTypeBean.getDesc());

          }

          @Override
          public void error(String error) {

          }
      });
    }
}
