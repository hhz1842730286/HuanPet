package com.jiyun.huanpet.model.biz.login;

import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.factor.MyFactor;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.utils.Utils;
import com.loc.ca;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lh on 2017/12/14.
 */

public class HomeLogin implements IHomeLogin {
    @Override
    public void login(String userName, String password, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("userPhone",userName);
        map.put("password",password);
        MyFactor.httpUtils().post(Urls.LOGIN,map,callback);
    }

    @Override
    public void fujin(String beginIndex, String coordX, String coordY, String endIndex, String orderBy, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("beginIndex",beginIndex);
        map.put("coordX",coordX);
        map.put("coordY",coordY);
        map.put("endIndex",endIndex);
        map.put("orderBy",orderBy);
        MyFactor.httpUtils().post(Urls.FUJIN,map,callback);
    }

    @Override
    public void petType(String beginIndex, String endIndex, String petTypeCode, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("beginIndex",beginIndex);
        map.put("endIndex",endIndex);
        map.put("petTypeCode",petTypeCode);
        MyFactor.httpUtils().post(Urls.PETCODE,map,callback);
    }



    @Override
    public void register(String userPhone, String userName, String password, String userImage, String threeId, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("userPhone",userPhone);
        map.put("userName",userName);
        map.put("password",password);
        map.put("userImage",userImage);
        map.put("threeId",threeId);
        MyFactor.httpUtils().post(Urls.THIRDREGISTER,map,callback);
    }

    @Override
    public void thirdLogin(String id, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("threeId",id);
        MyFactor.httpUtils().post(Urls.THIRDLOGIN,map,callback);
    }

    @Override
    public void forgetPassword(String userPhone, String password, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("userPhone",userPhone);
        map.put("password",password);
        MyFactor.httpUtils().post(Urls.FORGET,map,callback);
    }

    @Override
    public void details(String userId, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        MyFactor.httpUtils().post(Urls.HOMEDETAILS,map,callback);
    }

    @Override
    public void comment(String usersId, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("usersId",usersId);
        MyFactor.httpUtils().post(Urls.COMMENT,map,callback);
    }

    @Override
    public void TypeCode(String userId, String userName, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("userName",userName);
        MyFactor.httpUtils().post(Urls.UPDATE,map,callback);
    }

    @Override
    public void updataSex(String userId, String userSex,HttpCallback callback) {
        Map<String,Object> map = new HashMap();
        map.put("userId",userId);
        map.put("userSex",userSex);
        MyFactor.httpUtils().post(Urls.UPDATE,map,callback);
    }

    @Override
    public void updatabirth(String userId, String birthDay, HttpCallback callback) {
        Map<String,Object> map = new HashMap();
        map.put("userId",userId);
        map.put("birthDay",birthDay);
        MyFactor.httpUtils().post(Urls.UPDATE,map,callback);
    }

    @Override
    public void updataUserPhone(String userId, String userPhone, HttpCallback callback) {
        Map<String,Object> map = new HashMap();
        map.put("userId",userId);
        map.put("userPhone",userPhone);
        MyFactor.httpUtils().post(Urls.UPDATE,map,callback);
    }

    @Override
    public void updataweiin(String userId, String wechat,HttpCallback callback) {
        Map<String,Object> map = new HashMap();
        map.put("userId",userId);
        map.put("wechat",wechat);
        MyFactor.httpUtils().post(Urls.UPDATE,map,callback);
    }

    @Override
    public void updataQQ(String userId, String qq, HttpCallback callback) {
        Map<String,Object> map = new HashMap();
        map.put("userId",userId);
        map.put("qq",qq);
        MyFactor.httpUtils().post(Urls.UPDATE,map,callback);
    }
}
