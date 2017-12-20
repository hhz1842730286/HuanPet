package com.jiyun.huanpet.config;

/**
 * Created by mengYao on 2017/12/8.
 */

public class Urls {
    // 内网请求连接
    public static final String BASE_URL = "http://123.56.150.230:8885/dog_family/";
    //普通注册
    public static final String REGISTER = BASE_URL+"user/register.jhtml";
    //普通登录
    public static final String LOGIN = BASE_URL+"user/login.jhtml";
    //主页附近筛选
    public static final String FUJIN = BASE_URL+"users/getUsersInfoByVO.jhtml";
    //宠物类型
    public static final String PETCODE = BASE_URL+"petType/getPetTypesByVO.jhtml";
//    // 数据请求URL
    public static final String REQUESTURL = BASE_URL + "/dog_family/";

    // 请求图片的URL
    public static final String HTTP_IMAGE_URL = BASE_URL + "/dog_family/upload";
    //宠物添加
    public static final String PETADD=BASE_URL+"petInfo/savePetInfo.jhtml";
    //宠物列表
    public static final String PETLIST=BASE_URL+"petInfo/getPetInfoByUserId.jhtml";
    // 我的订单接口
    public static final String INDENT=BASE_URL+"orderInfo/getOrderInfoByUserId.jhtml";
}
