package com.jiyun.huanpet.presenter.indentpresenter;

import com.jiyun.huanpet.presenter.baseapi.BasePresenter;
import com.jiyun.huanpet.ui.base.BaseView;

/**
 * Created by Lenovo on 2017/12/18.
 */

public interface IIndentpresenter {
    interface View extends BaseView {

    }
    interface Presenter extends BasePresenter<View> {
       void indent(String userId, String  orderState);
       void particulars();
    }
}
