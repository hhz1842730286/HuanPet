package com.jiyun.huanpet.model.biz.Indent;

import com.jiyun.huanpet.config.Urls;
import com.jiyun.huanpet.model.api.HttpCallback;
import com.jiyun.huanpet.model.net.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2017/12/18.
 */

public class IndentModle implements IIndentModle {

    @Override
    public <T> void indent(String userId, int orderState, HttpCallback<T> callbake) {
        Map<String,Object> map=new HashMap<>();
        map.put("userId",userId);
        map.put("orderState",orderState);
        OkHttpUtils.getInstance().post(Urls.INDENT,map,callbake);
    }
}
