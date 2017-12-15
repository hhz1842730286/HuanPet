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
}
