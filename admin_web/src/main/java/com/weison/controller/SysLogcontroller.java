package com.weison.controller;

import com.github.pagehelper.PageInfo;
import com.weison.domain.SysLog;
import com.weison.service.SysLogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;


/**
 * 日志 控制器
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogcontroller {

    @Autowired
    private SysLogservice sysLogservice;

    /**
     * 查询所有日志记录
     * @param pagecur
     * @param pagesize
     * @return
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView FindAll(@RequestParam(required=true,defaultValue="1") Integer pagecur,
                                @RequestParam(required=false,defaultValue="6") Integer pagesize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("syslog-list");
        PageInfo<SysLog> page = sysLogservice.findall(pagecur, pagesize);
        modelAndView.addObject("page",page);
        return modelAndView;
    }
}
