package com.service;

import com.vo.ResultVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangxm
 * @Date: 2021/11/30 14:46
 */
@Service
public interface SysLoginService {

    ResultVo<Object> login(String username, String password, String code, HttpServletRequest request);

}
