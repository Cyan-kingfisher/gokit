package org.example.mall.util;


import org.example.mall.constant.error.HttpCodeEnum;
import org.example.mall.exception.GraduException;

/**
 * @author cyan
 * @since 2022/3/26
 */
public class AssertUtil {
    public static void isTure(boolean status, HttpCodeEnum error) {
         if (!status) throw new GraduException(error.toString());
    }
    public static void isNull(Object obj, HttpCodeEnum error) {
        if (obj!=null) throw new GraduException(error.toString());
    }
    public static void isNotNull(Object obj, HttpCodeEnum error) {
        if (obj==null) throw new GraduException(error.toString());
    }
}
