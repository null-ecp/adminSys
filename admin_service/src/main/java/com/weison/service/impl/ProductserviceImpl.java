package com.weison.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weison.dao.Productdao;
import com.weison.domain.Product;
import com.weison.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 产品业务处理
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ProductserviceImpl implements Productservice {

    @Autowired
    private Productdao productdao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public PageInfo<Product> findall(int pagecur, int pagesize) {
        PageHelper.startPage(pagecur, pagesize);
        PageInfo<Product> page = productdao.findall().toPageInfo();
        return page;
    }

    /**
     * 添加新产品
     * @param product 产品对象
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Product product){
//        product.setDepartureTime(DateUtil.Str2Date(product.getDepartureTimeStr(),"yyyy-mm-dd HH:MM"));
        productdao.add(product);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delcheck(String[] checkid) {
        for (String id : checkid) {
            productdao.delbyid(id);
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void opencheck(String[] checkids) {
        for (String id : checkids) {
            productdao.openbyid(id);
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void closecheck(String[] checkids) {
        for (String id : checkids) {
            productdao.closebyid(id);
        }
    }
}
