package com.jiyun.huanpet.presenter.updata;

import com.google.gson.Gson;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.login.HomeLogin;
import com.jiyun.huanpet.model.biz.login.IHomeLogin;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;
import com.jiyun.huanpet.view.UpdataWeiXinView;

/**
 * Created by lh on 2017/12/23.
 */

public class UpdataWeinPresenter implements IUpdataWeiInPresenter {
    private IHomeLogin iHomeLogin;
    private UpdataWeiXinView updataWeiXinView;

    public UpdataWeinPresenter(UpdataWeiXinView updataWeiXinView) {
        this.iHomeLogin = new HomeLogin();
        this.updataWeiXinView = updataWeiXinView;
    }

    @Override
    public void updataweiin(String userId, String wechat) {
        iHomeLogin.updataweiin(userId, wechat, new HttpCallback() {
            @Override
            public void success(Object o) {
                String string = o.toString();
                Gson gson = new Gson();
                ForgetPassWordBean forgetPassWordBean = gson.fromJson(string, ForgetPassWordBean.class);
                updataWeiXinView.updata(forgetPassWordBean);
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
