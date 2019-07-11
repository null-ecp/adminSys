package com.weison.domain;

import java.util.List;

/**
 * 访问权限实体类
 */
public class Permission {

    private String id;                  // 权限 id
    private String permissionName;      // 权限 名
    private String url;                 // 权限 可访问链接
    private List<Role> roles;           // 拥有该权限的角色

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
