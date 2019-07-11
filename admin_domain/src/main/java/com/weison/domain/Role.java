package com.weison.domain;

import java.util.List;

/**
 * 角色实体类
 */
public class Role {

    private String id;                          // 角色 id
    private String roleName;                    // 角色 名
    private String roleDesc;                    // 角色 描述
    private List<Permission> permissions;       // 角色 拥有的权限
    private List<UserInfo> users;                   // 拥有该角色身份的用户

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }

}
