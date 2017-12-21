package com.jiyun.huanpet.ui.activity.home.bean;

/**
 * Created by lh on 2017/12/21.
 */

public class ThirdLogin {

    /**
     * ret : true
     * result : {"isUse":0,"userPhone":18249009300,"password":"123456","userImage":"http://q.qlogo.cn/qqapp/100424468/8DF2EA6CB679B8F983E08615E2C8ADE0/100","threeId":"8DF2EA6CB679B8F983E08615E2C8ADE0","id":0,"state":0,"qq":0,"userSex":1,"userName":"etv446","userId":"a379f53327314fb9b44e013d7b5da28e","position":1}
     */

    private boolean ret;
    private ResultBean result;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * isUse : 0
         * userPhone : 18249009300
         * password : 123456
         * userImage : http://q.qlogo.cn/qqapp/100424468/8DF2EA6CB679B8F983E08615E2C8ADE0/100
         * threeId : 8DF2EA6CB679B8F983E08615E2C8ADE0
         * id : 0
         * state : 0
         * qq : 0
         * userSex : 1
         * userName : etv446
         * userId : a379f53327314fb9b44e013d7b5da28e
         * position : 1
         */

        private int isUse;
        private long userPhone;
        private String password;
        private String userImage;
        private String threeId;
        private int id;
        private int state;
        private int qq;
        private int userSex;
        private String userName;
        private String userId;
        private int position;

        public int getIsUse() {
            return isUse;
        }

        public void setIsUse(int isUse) {
            this.isUse = isUse;
        }

        public long getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(long userPhone) {
            this.userPhone = userPhone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getThreeId() {
            return threeId;
        }

        public void setThreeId(String threeId) {
            this.threeId = threeId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getQq() {
            return qq;
        }

        public void setQq(int qq) {
            this.qq = qq;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
