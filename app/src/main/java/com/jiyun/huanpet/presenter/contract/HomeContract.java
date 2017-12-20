package com.jiyun.huanpet.presenter.contract;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.FuJinBean;
import com.jiyun.huanpet.ui.activity.home.bean.PetTypeBean;
import com.jiyun.huanpet.ui.base.BaseView;

import java.util.List;

/**
 * Created by mengYao on 2017/12/9.
 */

public interface HomeContract {
    interface HomeView extends BaseView{
       void fujinview(List<FuJinBean.DescBean> fuJinBean);

       void petType(List<PetTypeBean.DescBean> descBeans);
    }
    interface HomePresenter extends BasePresenter<HomeView>{
        void fujinurl(String beginIndex,String coordX,String coordY,String endIndex,String orderBy);

        void petType(String beginIndex,String endIndex,String petTypeCode);

        void TypeCode(String beginIndex,String endIndex,String typeCode);
    }
}
