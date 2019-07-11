package com.weison.controller;

import com.github.pagehelper.PageInfo;
import com.weison.domain.UserInfo;
import com.weison.service.Roleservice;
import com.weison.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

/**
 * 用户模块控制器
 */
@Controller
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private Userservice userservice;
    @Autowired
    private Roleservice roleservice;

    /**
     * 查询所有用户集合
     * @param pagecur
     * @param pagesize
     * @return
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView FindAll(@RequestParam(required=true,defaultValue="1") Integer pagecur,
                                @RequestParam(required=false,defaultValue="6") Integer pagesize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-list");
        PageInfo<UserInfo> page = userservice.findall(pagecur, pagesize);
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    /**
     * 查询指定用户信息
     * @param id 用户id
     * @return
     */
    @RequestMapping("/findById.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-show");
        UserInfo userInfo = userservice.findbyid(id);
        modelAndView.addObject("user",userInfo);
        return modelAndView;
    }

    /**
     * 查询指定用户并获取该用户所有角色身份
     * @param id
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findUserByIdAndAllRole(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-role-add");
        modelAndView.addObject("user",userservice.findbyid(id));
        modelAndView.addObject("roleList",roleservice.findother(id));
        return modelAndView;
    }

    /**
     * 保存用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String saveuser(UserInfo userInfo){
        userservice.save(userInfo);
        return "redirect:findAll.do";
    }

    /**
     * 给用户添加新的角色
     * @param userId 用户id
     * @param roleIds 角色id
     * @return 重定向到用户详情页面
     */
    @RequestMapping("/addRoleToUser.do")
    @RolesAllowed("ADMIN")
    public String addRole2User(String userId,@RequestParam(name = "ids") String[] roleIds){
        // 添加记录进中间表
        userservice.addRole2User(userId, roleIds);
        return "redirect:findById.do?id="+userId;
    }
}
