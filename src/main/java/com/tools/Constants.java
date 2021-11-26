package com.tools;

import org.apache.catalina.security.SecurityUtil;

import javax.security.auth.Subject;
import javax.websocket.Session;
import java.security.cert.X509CertSelector;

/**
 * @Author: wangxm
 * @Date: 2021/11/26 14:35
 * 通用常量信息
 */
public class Constants {
    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";

    public static Session getSession(){
//        Subject subject = SecurityUtils.getSubject();
        return null;
    }

    public static void putCache(String key, Object value){
//        getSession()
    }
}
