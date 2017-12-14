package com.jiyun.huanpet.model.api;

import java.util.Map;

/**
 * Created by mengYao on 2017/12/8.
 */

public interface HttpRequest {
    <T>void get(String url, Map<String,String> headers,Map<String,String> params,HttpCallback<T> callback);
    <T>void get(String url, Map<String,String> headers,HttpCallback<T> callback);
    <T>void get(String url, HttpCallback<T> callback);
    <T>void post(String url, Map<String,String> headers,Map<String,String> params,HttpCallback<T> callback);
    <T>void post(String url, Map<String,String> params,HttpCallback<T> callback);
}
