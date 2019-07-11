package com.weison.dao;

import com.weison.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限查询持久层
 */
@Repository
public interface Permissiondao {

    public List<Permission> findbyroleid(@Param("roleid") String roleid);

    public List<Permission> findAll();

    public void save(Permission permission);

    public Permission findById(@Param("id") String id);

    public void delById(@Param("id") String id);

    List<Permission> findother(@Param("roleid") String id);
}
