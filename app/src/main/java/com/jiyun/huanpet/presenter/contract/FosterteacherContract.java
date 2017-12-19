package com.jiyun.huanpet.presenter.contract;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.base.BaseView;

/**
 * Created by 好阵风 on 2017/12/19.
 */

public interface FosterteacherContract {
    interface FosterteacherView extends BaseView {
        void onShow();
    }
    interface FosterteacherPresenter extends BasePresenter<FosterteacherView> {
        void lotoData();
    }
}
