package com.weison.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weison.dao.Roledao;
import com.weison.domain.Role;
import com.weison.service.Roleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * role 业务逻辑处理
 */
@Service
public class RoleserviceImpl implements Roleservice {

    @Autowired
    private Roledao roledao;

    @Override
    public PageInfo<Role> findall(Integer pagecur, Integer pagesize) {
        PageHelper.startPage(pagecur, pagesize);
        List<Role> roles = roledao.findAll();
        return new PageInfo<Role>(roles);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Role role) {
        roledao.save(role);
    }

    @Override
    public Role findById(String id) {
        return roledao.findById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addPermission2Role(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roledao.addPermission2Role(roleId,permissionId);
        }
    }

    @Override
    public List<Role> findother(String id) {
        return roledao.findother(id);
    }
}
