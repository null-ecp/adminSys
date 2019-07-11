package com.weison.service;

import com.github.pagehelper.PageInfo;
import com.weison.domain.Permission;

import java.util.List;


public interface Permissionservice {

    public PageInfo<Permission> findall(Integer pagecur, Integer pagesize);

    public void save(Permission permission);

    public Permission findById(String id);

    public void delById(String id);

    public List<Permission> findother(String id);
}
