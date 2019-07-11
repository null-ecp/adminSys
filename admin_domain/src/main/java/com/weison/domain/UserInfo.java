package com.weison.domain;

import java.util.List;

/**
 * 用户信息实体类
 */
public class UserInfo {

    private String id;              // 用户 id
    private String username;        // 用户 名
    private String email;           // 用户 邮箱
    private String password;        // 用户 密码
    private String phoneNum;        // 用户 号码
    private int status;             // 用户 状态
    private String statusStr;       // 状态 描述
    private List<Role> roles;       // 用户 拥有的角色

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        setStatusStr(getStatus() == 0? "未开启":"开启");
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
