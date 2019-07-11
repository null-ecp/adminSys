package com.weison.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weison.dao.Orderdao;
import com.weison.domain.Orders;
import com.weison.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单业务层
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class OrderserviceImpl implements Orderservice {

    @Autowired
    private Orderdao orderdao;
    /**
     * 查询所有订单列表
     * @return
     */
    @Override
    public PageInfo<Orders> findall(int pagecur, int pagesize) {
        PageHelper.startPage(pagecur,pagesize);
        PageInfo<Orders> page = orderdao.findall().toPageInfo();
        return page;
    }

    /**
     * 根据id查询指定订单
     * @param id
     * @return
     */
    @Override
    public Orders findById(String id) {
        return orderdao.findById(id);
    }
}
