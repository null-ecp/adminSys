package com.weison.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weison.dao.Roledao;
import com.weison.dao.Userdao;
import com.weison.domain.Role;
import com.weison.domain.UserInfo;
import com.weison.service.Userservice;
import com.weison.util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserserviceImpl implements Userservice {

    @Autowired
    private Userdao userdao;
    private Roledao roledao;

    /**
     * 登录权限验证
     * @param username 登录用户名
     * @return 登录用户的封装信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取登录用户信息
        UserInfo userInfo = userdao.findbyusername(username);
        // 获取用户 角色列表
        List<SimpleGrantedAuthority> authorities = getAuthority(userInfo.getRoles());
        User user = new User(userInfo.getUsername(),       // 用户名
                userInfo.getPassword(),                    // 密码
                userInfo.getStatus() == 0? false:true,     // 用户状态
                true,
                true,
                true, authorities         // 用户身份集合
        );
        return user;
    }

    /**
     * 获取权限身份集合
     * @param roles 角色集合
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    /**
     * 获取当前页面显示用户集合
     * @param pagecur 当前页码
     * @param pagesize 当前页面大小
     * @return
     */
    @Override
    public PageInfo<UserInfo> findall(Integer pagecur, Integer pagesize) {
        PageHelper.startPage(pagecur, pagesize);
        List<UserInfo> userInfos = userdao.findall();
        PageInfo<UserInfo> page = new PageInfo<UserInfo>(userInfos);
        return page;
    }

    /**
     * 根据id查询指定用户
     * @param id
     * @return
     */
    @Override
    public UserInfo findbyid(String id) {
        return userdao.findbyid(id);
    }

    /**
     * 保存用户
     * @param userInfo
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(UserInfo userInfo) {
        // 加密密码
        userInfo.setPassword(AuthUtil.encodepd(userInfo.getPassword()));
        userdao.save(userInfo);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addRole2User(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            userdao.addRole2User(userId,roleId);
        }
    }
}
