package com.weison.controller;

import com.github.pagehelper.PageInfo;
import com.weison.domain.Product;
import com.weison.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/product")
public class Productcontorller{

    @Autowired
    private Productservice productservice;

    /**
     * 查询所有产品
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView getproductlist(@RequestParam(required=true,defaultValue="1") Integer pagecur,
                                       @RequestParam(required=false,defaultValue="6") Integer pagesize) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product-list");
        PageInfo<Product> page = productservice.findall(pagecur, pagesize);
        modelAndView.addObject("page",page);
        return modelAndView;
    }

    /**
     * 添加产品
     * @param product
     * @return
     * @throws ParseException
     */
    @RequestMapping("/save.do")
    @RolesAllowed({"USER","ADMIN"})
    public String saveproduct(Product product) throws ParseException {
        productservice.save(product);
        return "redirect:findAll.do";
    }

    /**
     * 删除选中产品
     * @param checkids 选中的产品id数组
     * @return
     */
    @RequestMapping("/delcheck.do")
    @RolesAllowed("ADMIN")
    public String delcheck(@RequestParam(name = "check", required = false) String[] checkids){
        productservice.delcheck(checkids);
        return "redirect:findAll.do";
    }

    /**
     * 将选中商品的状态设置为开启
     * @param checkids
     * @return
     */
    @RequestMapping("/opencheck.do")
    @RolesAllowed({"USER","ADMIN"})
    public @ResponseBody Map<String, String> opencheck(@RequestParam(name = "check[]", required = false) String[] checkids){
        productservice.opencheck(checkids);
        Map<String, String> status = new HashMap<String, String>();
        status.put("status","success");
        return status;
    }

    /**
     * 将选中商品的状态设置为关闭
     * @param checkids
     * @return
     */
    @RequestMapping("/closecheck.do")
    @RolesAllowed({"USER","ADMIN"})
    public @ResponseBody Map<String, String> closecheck(@RequestParam(name = "check[]", required = false) String[] checkids){
        productservice.closecheck(checkids);
        Map<String, String> status = new HashMap<String, String>();
        status.put("status","success");
        return status;
    }
}
