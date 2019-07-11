package com.weison.log;

import com.weison.domain.SysLog;
import com.weison.service.SysLogservice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 使用AOP完成日志记录处理
 */
@Component
@Aspect
public class SysLogAOP {


    // web.xml配置监听器后自动生成的 , 我们可以直接注入
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SysLogservice sysLogservice;
    // 方法开始执行时间
    private Date starttime;
    // 执行 方法 的 类
    private Class executclass;
    // 执行 的 方法
    private Method executmethod;
    /**
     * 配置前置通知 , 对所有的controller中的方法进行增强
     * 用于获取切入时间(方法执行时间), 执行方法的类名, 执行的方法
     * @param jp 方法切入点对象(可以理解为封装切点方法后的对象)
     */
    @Before("execution(* com.weison.controller.*.*(..))")
    public void dobefore(JoinPoint jp) throws NoSuchMethodException {
        // 获取执行时间
        starttime = new Date();
        // 获取执行的方法的类
        executclass = jp.getTarget().getClass();
        // 获取执行的方法名
        String methodname = jp.getSignature().getName();
        // 获取执行方法的参数
        Object[] args = jp.getArgs();
        if (args == null || args.length == 0){ // 获取到的参数集合为null或者数组长度为0则为无参方法
            executmethod = executclass.getMethod(methodname);
        } else { // 表示执行方法有参数 需要 封装参数
            // 创建类数组来存储参数
            Class[] argsclass = new Class[args.length];
            // 循环写进参数
            for (int i = 0; i < argsclass.length; i++) {
                argsclass[i] = args[i].getClass();
            }
            executmethod = executclass.getMethod(methodname,argsclass);
        }
    }

    /**
     * 配置后置通知 , 对所有的controller中的方法进行增强
     * 用于获取方法执行时间(方法执行耗费时间), 访问用户, 访问用户的ip
     * @param jp 方法切入点对象(可以理解为封装切点方法后的对象)
     */
    @After("execution(* com.weison.controller.*.*(..))")
    public void doafter(JoinPoint jp){
        // 创建日志对象存储信息
        SysLog sysLog = new SysLog();
        // 获取执行时间
        long executtime = new Date().getTime() - starttime.getTime();
        // 获取访问的url
        String url = "";
        RequestMapping classurl = (RequestMapping) executclass.getAnnotation(RequestMapping.class);
        if (classurl != null) {
            url += classurl.value()[0];
        }
        RequestMapping methodurl = (RequestMapping) executmethod.getAnnotation(RequestMapping.class);
        if (methodurl != null) {
            url += methodurl.value()[0];
        }
        // 获取ip地址
        String ip = request.getRemoteAddr();
        // 获取访问用户
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();
        // 封装日志信息
        sysLog.setExecutionTime(executtime);
        sysLog.setIp(ip);
        sysLog.setMethod("[调用类] " + executclass.getName() + "\n[执行方法] " + executmethod.getName());
        sysLog.setUrl(url);
        sysLog.setUsername(username);
        sysLog.setVisitTime(starttime);
        sysLogservice.save(sysLog);
    }
}
