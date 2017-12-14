package com.jiyun.huanpet.factor;

import com.jiyun.huanpet.model.net.OkHttpUtils;

/**
 * Created by lh on 2017/12/14.
 */

public class MyFactor {
    public static OkHttpUtils httpUtils(){
        return OkHttpUtils.getInstance();
    }
}
