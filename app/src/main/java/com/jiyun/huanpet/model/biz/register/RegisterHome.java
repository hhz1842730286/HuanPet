package com.jiyun.huanpet.model.biz.register;

import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.factor.MyFactor;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.biz.RegisterIHome;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lh on 2017/12/14.
 */

public class RegisterHome implements RegisterIHome {
    @Override
    public void register(String userPhone, String userName, String password, HttpCallback callback) {
        Map<String,Object> parmers = new HashMap<>();
        parmers.put("userPhone",userPhone);
        parmers.put("userName",userName);
        parmers.put("password",password);
        MyFactor.httpUtils().post(Urls.REGISTER,parmers,callback);
    }
}
