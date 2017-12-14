package com.jiyun.huanpet.ui.activity.home.bean;

/**
 * Created by lh on 2017/12/12.
 */

public class Person  {
    private String Title ; //每条item的数据
    private boolean isChecked; //每条item的状态
    public Person(String title){
        Title = title;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
