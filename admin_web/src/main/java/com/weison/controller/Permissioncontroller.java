package com.weison.controller;

import com.github.pagehelper.PageInfo;
import com.weison.domain.Permission;
import com.weison.service.Permissionservice;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.security.RolesAllowed;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 资源权限控制器
 */
@Controller
@RequestMapping("/permission")
public class Permissioncontroller {

    @Autowired
    private Permissionservice permissionservice;

    /**
     * 查询所有权限
     * @param pagecur 当前页码
     * @param pagesize 当前页面数据展示数量
     * @return
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(required=true,defaultValue="1") Integer pagecur,
                                @RequestParam(required=false,defaultValue="6") Integer pagesize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("permission-list");
        PageInfo<Permission> page = permissionservice.findall(pagecur, pagesize);
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    /**
     * 添加权限
     * @param permission
     * @return 重定向权限列表页
     */
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")
    public String save(Permission permission){
        permissionservice.save(permission);
        return "redirect:findAll.do";
    }

    /**
     * 查看权限详情
     * @param id
     * @return
     */
    @RequestMapping("/findById.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("permission-show");
        Permission permission = permissionservice.findById(id);
        modelAndView.addObject("permission",permission);
        return modelAndView;
    }

    @RequestMapping("/deletePermission.do")
    @RolesAllowed("ADMIN")
    public String deletePermission(String id){
        permissionservice.delById(id);
        return "redirect:findAll.do";
    }
}
