package com.jiyun.huanpet.presenter.baseapi;

import com.jiyun.huanpet.ui.base.BaseView;

/**
 * Created by mengYao on 2017/12/8.
 */

public interface BasePresenter<T extends BaseView> {
    void attchTo(T t);
    void detach();
}
