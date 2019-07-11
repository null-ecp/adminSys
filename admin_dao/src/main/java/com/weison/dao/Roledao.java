package com.weison.dao;

import com.weison.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色 持久化接口
 */
@Repository
public interface Roledao {

    public List<Role> findbyuserid(@Param("userid") String id);

    public List<Role> findAll();

    public void save(Role role);

    public Role findById(@Param("id") String id);

    public void addPermission2Role(@Param("roleid") String roleId,@Param("permissionid") String permissionId);

    public List<Role> findother(@Param("userid") String id);
}
