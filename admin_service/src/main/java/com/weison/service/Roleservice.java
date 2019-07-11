package com.weison.service;

import com.github.pagehelper.PageInfo;
import com.weison.domain.Role;

import java.util.List;

public interface Roleservice {

    public PageInfo<Role> findall(Integer pagecur, Integer pagesize);

    public void save(Role role);

    public Role findById(String id);

    public void addPermission2Role(String roleId, String[] permissionIds);

    public List<Role> findother(String id);
}
