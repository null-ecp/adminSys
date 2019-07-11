package com.weison.dao;

import com.weison.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 日志 持久层
 */
@Repository
public interface SysLogdao {

    @Select("select * from sysLog")
    public List<SysLog> findAll();

    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) " +
            "values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog);
}
