package com.weison.controller;

import com.weison.domain.Orders;
import com.weison.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

/**
 * 订单控制层
 */
@Controller
@RequestMapping("/orders")
public class Oredercontroller {

    @Autowired
    private Orderservice orderservice;

    /**
     * 查询所有订单
     * @return
     */
    @RequestMapping("/findAll.do")
    @RolesAllowed({"USER","ADMIN"})
    public ModelAndView findall(@RequestParam(required=true,defaultValue="1") Integer pagecur,
                                @RequestParam(required=false,defaultValue="6") Integer pagesize){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("orders-list");
        modelAndView.addObject("page",orderservice.findall(pagecur, pagesize));
        return modelAndView;
    }

    /**
     * 查询订单详情
     * @param id
     * @return 返回订单详情封装页面
     */
    @RequestMapping("/findById.do")
    @RolesAllowed({"USER","ADMIN"})
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        Orders order = orderservice.findById(id);
        modelAndView.addObject("orders",order);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
