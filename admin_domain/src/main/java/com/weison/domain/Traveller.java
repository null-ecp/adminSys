package com.weison.domain;

public class Traveller {

    private String id;                              // 旅游人员id
    private String name;                            // 旅游人员姓名
    private String sex;                             // 旅游人员性别
    private String phoneNum;                        // 旅游人员电话号码
    private Integer credentialsType;                // 证件类型
    private String credentialsTypeStr;              // 证件类型描述
    private String credentialsNum;                  // 证件号码
    private Integer travellerType;                  // 旅游人员类型
    private String travellerTypeStr;                // 旅游人员类型描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        switch (getCredentialsType().intValue()){
            case 0:
                setCredentialsTypeStr("身份证");
                break;
            case 1:
                setCredentialsTypeStr("护照");
                break;
            case 2:
                setCredentialsTypeStr("军官证");
                break;
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        setTravellerTypeStr(getTravellerType().intValue() == 0? "成人":"儿童");
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
