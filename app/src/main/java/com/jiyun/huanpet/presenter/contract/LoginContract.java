package com.jiyun.huanpet.presenter.contract;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;
import com.jiyun.huanpet.ui.base.BaseView;

/**
 * Created by mengYao on 2017/12/9.
 */

public interface LoginContract {
    interface LoginView extends BaseView{
       void login(RegisterBean registerBean);
    }
    interface LoginPresenter extends BasePresenter<LoginView>{
        void url(String user,String pass);
    }
}
