package com.jiyun.huanpet.presenter.contract;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;
import com.jiyun.huanpet.ui.base.BaseView;

import java.util.List;

import static android.R.attr.x;

/**
 * Created by mengYao on 2017/12/11.
 */

public interface BindPhoneContract {
    interface BindPhoneView extends BaseView{
       void register(RegisterBean registerBean);
    }
    interface BindPhonePresenter extends BasePresenter<BindPhoneView>{
        void thirdregister(String userPhone,String userName,String password,String userImage,String threeId);
    }
}
