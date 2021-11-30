package com.tools;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @Author: wangxm
 * @Date: 2021/11/26 14:35
 * 通用常量信息/缓存工具类
 */
public class UserUtils {
    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    public static Session getSession(){
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if(session == null){
                session = subject.getSession();
            }
            if(session != null){
                return session;
            }
        }catch (InvalidSessionException e){

        }
        return null;
    }

    public static void putCache(String key, Object value){
        getSession().setAttribute(key,value);
    }

    public static Object getCache(String key){
        return getCache(key,null);
    }

    public static Object getCache(String key, Object defaultValue){
        Object obj = getSession().getAttribute(key);
        return obj == null?defaultValue:obj;
    }
}
