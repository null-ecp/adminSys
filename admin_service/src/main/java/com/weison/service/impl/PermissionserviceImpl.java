package com.weison.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weison.dao.Permissiondao;
import com.weison.domain.Permission;
import com.weison.service.Permissionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class PermissionserviceImpl implements Permissionservice {

    @Autowired
    private Permissiondao permissiondao;

    @Override
    public PageInfo<Permission> findall(Integer pagecur, Integer pagesize) {
        PageHelper.startPage(pagecur, pagesize);
        PageInfo<Permission> page = new PageInfo<Permission>(permissiondao.findAll());
        return page;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Permission permission) {
        permissiondao.save(permission);
    }

    @Override
    public Permission findById(String id) {
        return permissiondao.findById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delById(String id) {
        permissiondao.delById(id);
    }

    @Override
    public List<Permission> findother(String id) {
        return permissiondao.findother(id);
    }

}
