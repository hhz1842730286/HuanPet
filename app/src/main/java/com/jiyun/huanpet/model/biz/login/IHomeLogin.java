package com.jiyun.huanpet.model.biz.login;

import com.jiyun.huanpet.model.api.HttpCallback;

/**
 * Created by lh on 2017/12/14.
 */

public interface IHomeLogin<T> {
    //登录网址拼接
    <T>void login(String userName, String password, HttpCallback<T> callback);
    //主页附近筛选
    <T>void fujin(String beginIndex,String coordX,String coordY,String endIndex,String orderBy,HttpCallback<T> callback);
    //宠物类型
    <T>void petType(String beginIndex,String endIndex,String petTypeCode,HttpCallback<T> callback);
    //宠物类型筛选
    <T>void TypeCode(String beginIndex, String endIndex, String typeCode,HttpCallback<T> callback);
    //第三方注册
    <T>void register(String userPhone, String userName, String password, String userImage, String threeId,HttpCallback<T> callback);
    //第三方登录
    <T>void thirdLogin(String id,HttpCallback<T> callback);
}
