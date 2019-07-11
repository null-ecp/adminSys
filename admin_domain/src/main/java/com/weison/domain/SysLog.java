package com.weison.domain;

import com.weison.util.DateUtil;

import java.util.Date;

/**
 * 日志类
 */
public class SysLog {
    private String id;                  // 日志 id
    private Date visitTime;             // 访问时间
    private String visitTimeStr;
    private String username;            // 访问用户 用户名
    private String ip;                  // 访问用户 id
    private String url;                 // 访问路径
    private Long executionTime;         // 执行访问操作时间
    private String method;              // 执行方法


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        setVisitTimeStr(DateUtil.Date2Str(getVisitTime(),"yyyy-MM-dd HH:mm"));
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
