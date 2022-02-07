package com.controller;

import com.domain.Example.LoginBody;
import com.domain.Example.UserRoleExample;
import com.domain.Role;
import com.domain.User;
import com.domain.UserRole;
import com.service.RoleService;
import com.service.SysLoginService;
import com.service.UserRoleService;
import com.tools.CacheUtils;
import com.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录")
    public ResultVo<Object> login(@RequestBody LoginBody loginBody, HttpServletRequest request) {
        return sysLoginService.login(loginBody.getUsername(),loginBody.getPassword(),loginBody.getCode(),request);
    }

    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息")
    public ResultVo<Object> getInfo(HttpServletRequest request) {
        User user = (User) CacheUtils.getCache(CacheUtils.LoginUser,request);
        // 角色
        UserRoleExample example = new UserRoleExample();
        example.setUid(user.getId());
        List<UserRole> userRole = userRoleService.page(example);
        Role roles = roleService.selectByPrimaryKey(userRole.get(0).getRid());
        // 权限集合
        String permissions = "*:*:*";
        Map<String,Object> ajax = new HashMap<>();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ResultVo.success(ajax);
    }

    @RequestMapping(value = "/getRouters",method = RequestMethod.GET)
    @ApiOperation(value = "获取路由信息")
    public ResultVo<Object> getRouters() {
        return null;
    }

}
