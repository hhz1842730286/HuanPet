package com.jiyun.huanpet.model.biz.login;

import com.jiyun.huanpet.model.api.HttpCallback;

/**
 * Created by lh on 2017/12/14.
 */

public interface IHomeLogin<T> {
    //登录网址拼接
    <T>void login(String userName, String password, HttpCallback<T> callback);
}
