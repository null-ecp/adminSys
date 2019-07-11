package com.weison.service;

import com.github.pagehelper.PageInfo;
import com.weison.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface Userservice extends UserDetailsService {

    public PageInfo<UserInfo> findall(Integer pagecur, Integer pagesize);

    public UserInfo findbyid(String id);

    public void save(UserInfo userInfo);

    public void addRole2User(String userId, String[] roleIds);
}
