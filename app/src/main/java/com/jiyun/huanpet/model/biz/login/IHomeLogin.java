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
    <T>void TypeCode(String userId, String userName,HttpCallback<T> callback);
    //第三方注册
    <T>void register(String userPhone, String userName, String password, String userImage, String threeId,HttpCallback<T> callback);
    //第三方登录
    <T>void thirdLogin(String id,HttpCallback<T> callback);
    //修改密码
    <T>void forgetPassword(String userPhone, String password,HttpCallback<T> callback);
    //首页详情(寄养师)
    <T>void details(String userId,HttpCallback<T> callback);
    //获取评论接口
    <T>void comment(String usersId,HttpCallback<T> callback);
    //修改性别
    <T>void updataSex(String userId,String userSex,HttpCallback<T> callback);
    //修改如期
    <T>void updatabirth(String userId,String birthDay,HttpCallback<T> callback);
    //修改手机号
    <T>void updataUserPhone(String userId,String userPhone,HttpCallback<T> callback);
    //修改微信
    <T>void updataweiin(String userId, String wechat,HttpCallback<T> callback);
    //修改QQ
    <T>void updataQQ(String userId, String qq,HttpCallback<T> callback);
}
