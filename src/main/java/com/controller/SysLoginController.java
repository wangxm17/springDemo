package com.controller;

import com.domain.Example.LoginBody;
import com.service.SysLoginService;
import com.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wangxm
 * @Date: 2021/11/30 14:34
 * 登录验证
 */
@RestController
@Api(value = "SysLoginController",description = "登录(wxm)")
public class SysLoginController {

    @Autowired
    SysLoginService sysLoginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录")
    public ResultVo<Object> login(@RequestBody LoginBody loginBody, HttpServletRequest request) {
        return sysLoginService.login(loginBody.getUsername(),loginBody.getPassword(),loginBody.getCode(),request);
    }

    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    @ApiOperation(value = "登出")
    public ResultVo<Object> loginOut(HttpServletRequest request) {
        return sysLoginService.loginOut(request);
    }

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息")
    public ResultVo<Object> getInfo(HttpServletRequest request) {
        return ResultVo.success(sysLoginService.getUserInfo(request));
    }

}
