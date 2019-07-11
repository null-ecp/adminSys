package com.weison.dao;

import com.github.pagehelper.Page;
import com.weison.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品 持久化接口
 */
@Repository
public interface Productdao {

    /**
     * 查询所有产品
     * @return
     */
    @Select("select * from product")
    public Page<Product> findall();

    @Select("select * from product where id = #{id}")
    public Product findbyid(@Param("id") String id);

    /**
     * 添加产品
     * @param product
     */
    @Insert("insert into product(productnum,productname,cityname,departuretime,productprice,productdesc,productstatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void add(Product product);

    @Delete("delete from product where id = #{id}")
    public void delbyid(@Param("id") String id);

    @Update("update product set productstatus = 1 where id = #{id}")
    public void openbyid(@Param("id") String id);

    @Update("update product set productstatus = 0 where id = #{id}")
    public void closebyid(@Param("id") String id);
}
