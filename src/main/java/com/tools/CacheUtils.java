package com.tools;

import com.domain.User;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangxm
 * @Date: 2021/11/26 14:35
 * 通用常量/缓存工具类
 */
public class CacheUtils {
    /**
     * 验证码 code key
     */
    public static final String CODE_KEY = "captcha_codes:";

    /**
     * 用户 code key
     */
    public static final String LoginUser = null;

    public static void putCache(String key, Object value, HttpServletRequest request){
        request.getSession().setAttribute(key, value);
    }

    public static Object getCache(String key, HttpServletRequest request){
        return request.getSession().getAttribute(key);
    }

    public static void removeCache(String key, HttpServletRequest request){
        request.getSession().removeAttribute(key);
    }

}
