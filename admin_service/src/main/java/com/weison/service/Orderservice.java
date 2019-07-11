package com.weison.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.weison.domain.Orders;;

public interface Orderservice {

    public PageInfo<Orders> findall(int pagecur, int pagesize);

    public Orders findById(String id);
}
