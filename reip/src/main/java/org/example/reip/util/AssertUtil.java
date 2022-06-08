package org.example.reip.util;


import org.example.reip.constant.error.HttpCodeEnum;
import org.example.reip.exception.GraduException;

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
