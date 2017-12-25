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
    //首页详情页(寄养家庭)
    public static final String HOMEDETAILS = BASE_URL+"users/getUsersInfos.jhtml";
    //第三方注册
    public static final String THIRDREGISTER = BASE_URL+"user/register.jhtml";
    //第三方登录
    public static final String THIRDLOGIN = BASE_URL+"user/login.jhtml";
    //忘记密码
    public static final String FORGET = BASE_URL+"user/updatePassword.jhtml";
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
    //订单详情
    public static final String PARTICULARS=BASE_URL+"petInfo/getPetInfoByPetId.jhtml";
    //评论
    public static final String COMMENT = BASE_URL+"usersEvaluatedInfo/getUsersEvaluatedInfoByVO.jhtml";
    //各人信息修改
    public static final String UPDATE = BASE_URL+"user/updateUserInfo.jhtml";
}
