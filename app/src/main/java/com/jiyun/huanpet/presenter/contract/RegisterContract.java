package com.jiyun.huanpet.presenter.contract;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;
import com.jiyun.huanpet.ui.base.BaseView;

/**
 * Created by mengYao on 2017/12/10.
 */

public interface RegisterContract {

    interface RegisterView extends BaseView{
        void register(RegisterBean registerBean);
    }
    interface RegisterPresenter extends BasePresenter<RegisterView>{
        void url(String phone,String user,String pass);
    }


}
