package com.weison.service;

import com.github.pagehelper.PageInfo;
import com.weison.domain.Product;

import java.text.ParseException;

public interface Productservice {

    public PageInfo<Product> findall(int pagecur, int pagesize);

    public void save(Product product) throws ParseException;

    public void delcheck(String[] checkid);

    public void opencheck(String[] checkids);

    public void closecheck(String[] checkids);
}
