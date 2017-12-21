package com.jiyun.huanpet.ui.activity.home.bean;

/**
 * Created by Lenovo on 2017/12/20.
 */

public class AllAtiity {
    private int NameImage;
    private int pinjieImage;
    private int petImage;
    private String  Wangeng;

    public int getNameImage() {
        return NameImage;
    }

    public void setNameImage(int nameImage) {
        NameImage = nameImage;
    }

    public int getPinjieImage() {
        return pinjieImage;
    }

    public void setPinjieImage(int pinjieImage) {
        this.pinjieImage = pinjieImage;
    }

    public int getPetImage() {
        return petImage;
    }

    public void setPetImage(int petImage) {
        this.petImage = petImage;
    }

    public String getWangeng() {
        return Wangeng;
    }

    public void setWangeng(String wangeng) {
        Wangeng = wangeng;
    }

    @Override
    public String toString() {
        return "AllAtiity{" +
                "NameImage=" + NameImage +
                ", pinjieImage=" + pinjieImage +
                ", petImage=" + petImage +
                ", Wangeng='" + Wangeng + '\'' +
                '}';
    }
}
