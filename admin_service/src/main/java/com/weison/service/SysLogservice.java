package com.weison.service;

import com.github.pagehelper.PageInfo;
import com.weison.domain.SysLog;
import com.weison.domain.UserInfo;

/**
 * 日志业务处理类
 */
public interface SysLogservice {

    public PageInfo<SysLog> findall(Integer pagecur, Integer pagesize);

    public void save(SysLog sysLog);
}
