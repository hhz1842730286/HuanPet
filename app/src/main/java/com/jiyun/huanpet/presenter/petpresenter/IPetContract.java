package com.jiyun.huanpet.presenter.petpresenter;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.base.BaseView;

/**
 * Created by Lenovo on 2017/12/18.
 */

public interface IPetContract {
    interface View extends BaseView {

    }
    interface Presenter extends BasePresenter<View> {
       void pet(String userId);
       void petadd(String petName, int PetType, String userName, String CreateTime, String petBirthTime, String petInfo, String petTypeName, String isSterilization, String petWeight, String isimmune, String userId);
    }

}
