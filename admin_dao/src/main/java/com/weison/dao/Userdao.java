package com.weison.dao;

import com.weison.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user 对象持久层
 */
@Repository
public interface Userdao {

    public UserInfo findbyusername(@Param("username") String username);

    public List<UserInfo> findbyroleid(@Param("roleid") String id);

    public List<UserInfo> findall();

    public UserInfo findbyid(@Param("id") String id);

    public void save(UserInfo userInfo);

    public void addRole2User(@Param("userid") String userId,@Param("roleid") String roleId);
}
