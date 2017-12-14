package com.jiyun.huanpet.model.api;

/**
 * Created by mengYao on 2017/12/8.
 */

public interface HttpCallback<T> {
    void success(T t);
    void error(String error);
}
