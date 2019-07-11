package com.weison.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weison.dao.SysLogdao;
import com.weison.domain.Role;
import com.weison.domain.SysLog;
import com.weison.domain.UserInfo;
import com.weison.service.SysLogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogserviceImpl implements SysLogservice {

    @Autowired
    private SysLogdao sysLogdao;

    @Override
    public PageInfo<SysLog> findall(Integer pagecur, Integer pagesize) {
        PageHelper.startPage(pagecur, pagesize);
        List<SysLog> roles = sysLogdao.findAll();
        return new PageInfo<SysLog>(roles);
    }

    @Override
    public void save(SysLog sysLog) {
        sysLogdao.save(sysLog);
    }
}
