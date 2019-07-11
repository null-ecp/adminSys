package com.weison.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.weison.domain.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单持久化接口
 */
@Repository
public interface Orderdao {

    public Page<Orders> findall();

    public Orders findById(@Param("id") String id);
}
