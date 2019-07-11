package com.weison.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密工具类
 */
public class AuthUtil {

    /**
     * 加密处理对象
     */
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 对指定字符串进行加密
     * @param pd
     * @return
     */
    public static String encodepd(String pd){
        return bCryptPasswordEncoder.encode(pd);
    }

    public static void main(String[] args) {
        System.out.println(encodepd("admin"));
    }
}
