package com.weison.controller;


import com.github.pagehelper.PageInfo;
import com.weison.domain.Role;
import com.weison.service.Permissionservice;
import com.weison.service.Roleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

/**
 * 角色身份控制器
 */
@Controller
@RequestMapping("/role")
public class Rolecontroller {

    @Autowired
    private Roleservice roleservice;
    @Autowired
    private Permissionservice permissionservice;

    /**
     * 查询所有角色信息
     * @param pagecur
     * @param pagesize
     * @return
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(required=true,defaultValue="1") Integer pagecur,
                                @RequestParam(required=false,defaultValue="6") Integer pagesize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-list");
        PageInfo<Role> roles = roleservice.findall(pagecur, pagesize);
        modelAndView.addObject("page",roles);
        return modelAndView;
    }

    /**
     * 查询指定角色信息
     * @param id
     * @return 返回角色信息封装页面
     */
    @RequestMapping("/findById.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-show");
        Role role = roleservice.findById(id);
        modelAndView.addObject("role",role);
        return modelAndView;
    }

    /**
     * 保存角色
     * @param role
     * @return
     */
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String saveuser(Role role){
        roleservice.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 给指定角色添加权限
     * @param roleId 角色id
     * @param permissionIds 权限id数组
     * @return 重定向到角色详情页
     */
    @RequestMapping("/addPermissionToRole.do")
    @RolesAllowed("ADMIN")
    public String addPermission2Role(String roleId,@RequestParam(name = "ids") String[] permissionIds){
        // 添加记录进中间表
        roleservice.addPermission2Role(roleId, permissionIds);
        return "redirect:findById.do?id="+roleId;
    }

    /**
     * 根据id查询指定角色 并 查询所有权限封装
     * @param id
     * @return 返回封装数据的页面
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findRoleByIdAndAllPermission(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("role-permission-add");
        modelAndView.addObject("role",roleservice.findById(id));
        modelAndView.addObject("permissionList",permissionservice.findother(id));
        return modelAndView;
    }
}
