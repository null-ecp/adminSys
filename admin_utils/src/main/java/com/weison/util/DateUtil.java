package com.weison.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * Date转字符串
     * @param date date对象
     * @param req 转换规则
     * @return
     */
    public static String Date2Str(Date date, String req){
        SimpleDateFormat smf = new SimpleDateFormat(req);
        return smf.format(date);
    }

    public static Date Str2Date(String dateStr, String req) {
        SimpleDateFormat smf = new SimpleDateFormat(req);
        try {
            return smf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
