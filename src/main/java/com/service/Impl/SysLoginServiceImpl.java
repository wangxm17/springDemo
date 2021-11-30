package com.service.Impl;

import com.dao.UserMapper;
import com.domain.Example.UserExample;
import com.domain.User;
import com.service.SysLoginService;
import com.tools.CacheUtils;
import com.tools.TokenUtils;
import com.vo.CodeMsg;
import com.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/11/30 14:47
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    UserMapper userMapper;

    @Override
    public ResultVo<Object> login(String username, String password, String code, HttpServletRequest request) {
        // 验证码
        if (!validateCaptcha(code,request))
        {
            return ResultVo.error(CodeMsg.CODE_ERROR);
        }
        // 用户验证
        if (!validateUser(username,password))
        {
            return ResultVo.error(CodeMsg.USER_ERROR);
        }
        // 生成token
        String token = TokenUtils.token(username,password);
        return ResultVo.success(token);
    }

    /**
     * 校验验证码
     * @param code 验证码
     * @return
     */
    public boolean validateCaptcha(String code, HttpServletRequest request)
    {
        String captcha = (String) CacheUtils.getCache(CacheUtils.CODE_KEY,request);
        if (code == null)
        {
            return false;
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            return false;
        }
        return true;
    }

    /**
     * 校验用户
     * @param username 用户
     * @param password 密码
     * @return
     */
    public boolean validateUser(String username, String password)
    {
        UserExample example = new UserExample();
        example.setUserName(username);
        example.setPassword(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.size()>0)
        {
            return true;
        }
        return false;
    }
}
