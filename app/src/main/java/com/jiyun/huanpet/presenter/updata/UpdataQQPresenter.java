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

public class UpdataQQPresenter implements UpdataQQ {
    private IHomeLogin iHomeLogin;
    private UpdataWeiXinView updataWeiXinView;

    public UpdataQQPresenter(UpdataWeiXinView updataWeiXinView) {
        this.updataWeiXinView = updataWeiXinView;
        this.iHomeLogin = new HomeLogin();
    }

    @Override
    public void updataQQ(String userId, String qq) {
        iHomeLogin.updataQQ(userId, qq, new HttpCallback() {
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
