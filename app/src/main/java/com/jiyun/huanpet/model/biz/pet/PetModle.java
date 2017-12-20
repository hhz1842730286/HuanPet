package com.jiyun.huanpet.model.biz.pet;

import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.factor.MyFactor;
import com.jiyun.huanpet.model.api.HttpCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2017/12/17.
 */

public class PetModle implements IPetModle{

    @Override
    public void petlist(String userId, HttpCallback callbke) {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        MyFactor.httpUtils().post(Urls.PETLIST,map,callbke);
    }


    @Override
    public void petadd( String petName, int PetType, String userName, String CreateTime, String petBirthTime, String petInfo, String petTypeName, String isSterilization, String petWeight, String isimmune, String userId, HttpCallback callback) {
        Map<String,Object> mapq=new HashMap<>();
        mapq.put("petName",petName);
        mapq.put("PetType",PetType);
        mapq.put("userName",userName);
        mapq.put("CreateTime",CreateTime);
        mapq.put("petBirthTime",petBirthTime);
        mapq.put("petInfo",petInfo);
        mapq.put("petTypeName",petTypeName);
        mapq.put("isSterilization",isSterilization);
        mapq.put("petWeight",petWeight);
        mapq.put("isimmune",isimmune);
        mapq.put("userId",userId);
        MyFactor.httpUtils().post(Urls.PETADD,mapq,callback);
    }
}
