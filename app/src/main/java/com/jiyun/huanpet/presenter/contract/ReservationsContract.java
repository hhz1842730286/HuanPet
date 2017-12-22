package com.jiyun.huanpet.presenter.contract;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.activity.home.bean.RegisterBean;
import com.jiyun.huanpet.ui.base.BaseView;

/**
 * Created by 好阵风 on 2017/12/22.
 */

public interface ReservationsContract {
    interface ReservationsView extends BaseView {
        void register();
    }
    interface ReservationsPresenter extends BasePresenter<ReservationsContract.ReservationsView> {
        void url();
    }

}
