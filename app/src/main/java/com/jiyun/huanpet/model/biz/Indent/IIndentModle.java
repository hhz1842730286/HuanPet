package com.jiyun.huanpet.model.biz.Indent;

import com.jiyun.huanpet.model.api.HttpCallback;

/**
 * Created by Lenovo on 2017/12/18.
 */

public interface IIndentModle {
     <T>void indent(String userId, String orderState, HttpCallback<T> callbake);
     <T> void particulars(HttpCallback<T> callback);
}
