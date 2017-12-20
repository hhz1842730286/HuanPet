package com.jiyun.huanpet.model.biz.pet;

import com.jiyun.huanpet.model.api.HttpCallback;

/**
 * Created by Lenovo on 2017/12/17.
 */

public interface IPetModle {
    <T>void  petlist(String userId, HttpCallback<T> callbke);
    <T> void petadd(String petName,int PetType,String userName,String CreateTime,String petBirthTime,String petInfo,String petTypeName,String isSterilization,String petWeight,String isimmune,String userId,HttpCallback<T> callback);

}
