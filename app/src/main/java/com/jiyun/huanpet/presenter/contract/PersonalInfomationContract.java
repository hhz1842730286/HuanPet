package com.jiyun.huanpet.presenter.contract;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.ForgetPassWordBean;
import com.jiyun.huanpet.ui.base.BaseView;

/**
 * Created by mengYao on 2017/12/12.
 */

public interface PersonalInfomationContract {
    interface PersonalInfomationView extends BaseView{

       void updatasex(ForgetPassWordBean bean);

       void updataSexMan(ForgetPassWordBean bean);

       void updataBirth(ForgetPassWordBean bean);
    }
    interface PersonalInfomationPresenter extends BasePresenter<PersonalInfomationView>{
       void updataSex(String userId,String userSex);

       void updataSexMan(String userId,String userSex);

       void updataBirth(String userId,String birthDay);

       void updataUserPhone(String userId,String userPhone);
    }
}
