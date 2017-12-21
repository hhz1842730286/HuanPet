package com.jiyun.huanpet.model.biz.login;

import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.factor.MyFactor;
import com.jiyun.huanpet.model.api.HttpCallback;

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
    public void TypeCode(String beginIndex, String endIndex, String typeCode, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("beginIndex",beginIndex);
        map.put("endIndex",endIndex);
        map.put("typeCode",typeCode);
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
}
