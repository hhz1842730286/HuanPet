package com.jiyun.huanpet.model.biz;

import com.jiyun.huanpet.model.api.HttpCallback;

/**
 * Created by lh on 2017/12/14.
 */

public interface RegisterIHome<T> {
    //普通注册
    <T>void register(String userPhone, String userName, String password, HttpCallback<T> callback);

}
