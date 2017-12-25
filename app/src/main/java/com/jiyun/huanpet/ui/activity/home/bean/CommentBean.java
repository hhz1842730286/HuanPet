package com.jiyun.huanpet.ui.activity.home.bean;

import java.util.List;

/**
 * Created by lh on 2017/12/22.
 */

public class CommentBean {

    /**
     * ret : true
     * desc : [{"isUse":0,"petTypeDesc":"","orderCount":0,"description":"很棒","userName":"棒子s","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":4,"evaluatedCount":0,"userImage":"/15ecf9c30f0847cb99c0c284ec411a24/1459391816473.png","createTime":"2016-06-18","id":0,"petDuration":5},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"wewe","userName":"棒子s","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":5,"evaluatedCount":0,"createTime":"2016-06-18","id":0,"petDuration":7},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"不好","userName":"棒子s","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":1,"evaluatedCount":0,"createTime":"2016-06-20","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"完美","userName":"棒子s","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":5,"evaluatedCount":0,"createTime":"2016-06-20","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"qwe","userName":"棒子s","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":4,"evaluatedCount":0,"createTime":"2016-06-20","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"123","userName":"棒子s","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":4,"evaluatedCount":0,"createTime":"2016-06-20","id":0,"petDuration":7},{"isUse":0,"petTypeDesc":"","orderCount":0,"description":"qweqweqwe","userName":"棒子s","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":4,"evaluatedCount":0,"userImage":"/15ecf9c30f0847cb99c0c284ec411a24/1459391816473.png","createTime":"2016-06-20","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"啊啊啊","userName":"棒子s","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":5,"evaluatedCount":0,"createTime":"2016-06-20","id":0,"petDuration":7},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"haohaohao","userName":"棒子","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":4,"evaluatedCount":0,"createTime":"2016-06-20","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"qwe","userName":"棒子","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":3,"evaluatedCount":0,"createTime":"2016-06-21","id":0,"petDuration":7},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"宠物都被你养死了","userName":"棒子","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":1,"evaluatedCount":0,"createTime":"2016-06-21","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"养的我的宠物都挑食了","userName":"棒子","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":2,"evaluatedCount":0,"createTime":"2016-06-21","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"完美！！！！！！","userName":"棒子","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":5,"evaluatedCount":0,"createTime":"2016-06-21","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"好000000000000","userName":"棒子呀","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":4,"evaluatedCount":0,"createTime":"2016-06-24","id":0,"petDuration":2},{"isUse":0,"petTypeDesc":"没救了","orderCount":0,"description":"！！！！！！！","userName":"棒子呀","userId":"15ecf9c30f0847cb99c0c284ec411a24","score":4,"evaluatedCount":0,"createTime":"2016-06-24","id":0,"petDuration":7}]
     */

    private boolean ret;
    private List<DescBean> desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public List<DescBean> getDesc() {
        return desc;
    }

    public void setDesc(List<DescBean> desc) {
        this.desc = desc;
    }

    public static class DescBean {
        /**
         * isUse : 0
         * petTypeDesc :
         * orderCount : 0
         * description : 很棒
         * userName : 棒子s
         * userId : 15ecf9c30f0847cb99c0c284ec411a24
         * score : 4
         * evaluatedCount : 0
         * userImage : /15ecf9c30f0847cb99c0c284ec411a24/1459391816473.png
         * createTime : 2016-06-18
         * id : 0
         * petDuration : 5
         */

        private int isUse;
        private String petTypeDesc;
        private int orderCount;
        private String description;
        private String userName;
        private String userId;
        private int score;
        private int evaluatedCount;
        private String userImage;
        private String createTime;
        private int id;
        private int petDuration;

        public int getIsUse() {
            return isUse;
        }

        public void setIsUse(int isUse) {
            this.isUse = isUse;
        }

        public String getPetTypeDesc() {
            return petTypeDesc;
        }

        public void setPetTypeDesc(String petTypeDesc) {
            this.petTypeDesc = petTypeDesc;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getEvaluatedCount() {
            return evaluatedCount;
        }

        public void setEvaluatedCount(int evaluatedCount) {
            this.evaluatedCount = evaluatedCount;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPetDuration() {
            return petDuration;
        }

        public void setPetDuration(int petDuration) {
            this.petDuration = petDuration;
        }
    }
}
