package com.jiyun.huanpet.ui.activity.home.bean;

/**
 * Created by Lenovo on 2017/12/18.
 */

public class Petadd {
    private long id;
    private String petCode;
    private String petName;
    private String userId;
    private String userName;
    private int petSex;
    private String petBirthTime;
    private String petInfo;
    private String createTime;
    private String updateTime;
    private String petImage;
    private String petType;
    private String petTypeName;
    private int isSterilization;
    private double petWeight;
    private String petPricingCode;
    private int petState;
    private int isUse;
    private int isimmune;
    private String petParentTypeCode;
    private String petParentTypeName;

    public String getPetParentTypeName() {
        return petParentTypeName;
    }

    public void setPetParentTypeName(String petParentTypeName) {
        this.petParentTypeName = petParentTypeName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPetParentTypeCode() {
        return petParentTypeCode;
    }

    public void setPetParentTypeCode(String petParentTypeCode) {
        this.petParentTypeCode = petParentTypeCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPetCode() {
        return petCode;
    }

    public void setPetCode(String petCode) {
        this.petCode = petCode;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPetSex() {
        return petSex;
    }

    public void setPetSex(int petSex) {
        this.petSex = petSex;
    }

    public String getPetBirthTime() {
        return petBirthTime;
    }

    public void setPetBirthTime(String petBirthTime) {
        this.petBirthTime = petBirthTime;
    }

    public String getPetInfo() {
        return petInfo;
    }

    public void setPetInfo(String petInfo) {
        this.petInfo = petInfo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetTypeName() {
        return petTypeName;
    }

    public void setPetTypeName(String petTypeName) {
        this.petTypeName = petTypeName;
    }

    public int getIsSterilization() {
        return isSterilization;
    }

    public void setIsSterilization(int isSterilization) {
        this.isSterilization = isSterilization;
    }

    public double getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(double petWeight) {
        this.petWeight = petWeight;
    }

    public String getPetPricingCode() {
        return petPricingCode;
    }

    public void setPetPricingCode(String petPricingCode) {
        this.petPricingCode = petPricingCode;
    }

    public int getPetState() {
        return petState;
    }

    public void setPetState(int petState) {
        this.petState = petState;
    }

    public String getPetImage() {
        return petImage;
    }

    public void setPetImage(String petImage) {
        this.petImage = petImage;
    }

    public int getIsimmune() {
        return isimmune;
    }

    public void setIsimmune(int isimmune) {
        this.isimmune = isimmune;
    }

    @Override
    public String toString() {
        return "PetInfo [id=" + id + ", petCode=" + petCode + ", petName="
                + petName + ", userId=" + userId + ", userName=" + userName
                + ", petSex=" + petSex + ", petBirthTime=" + petBirthTime
                + ", petInfo=" + petInfo + ", createTime=" + createTime
                + ", updateTime=" + updateTime + ", petImage=" + petImage
                + ", petType=" + petType + ", petTypeName=" + petTypeName
                + ", isSterilization=" + isSterilization + ", petWeight="
                + petWeight + ", petPricingCode=" + petPricingCode
                + ", petState=" + petState + ", isUse=" + isUse + ", isimmune="
                + isimmune + ", petParentTypeCode=" + petParentTypeCode
                + ", petParentTypeName=" + petParentTypeName + "]";
    }

}
