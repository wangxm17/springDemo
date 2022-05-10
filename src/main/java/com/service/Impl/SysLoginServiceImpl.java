package com.service.Impl;

import com.dao.UserMapper;
import com.domain.Example.UserExample;
import com.domain.Example.UserRoleExample;
import com.domain.Permission;
import com.domain.User;
import com.domain.UserRole;
import com.domain.Role;
import com.service.*;
import com.tools.CacheUtils;
import com.tools.TokenUtils;
import com.vo.CodeMsg;
import com.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: wangxm
 * @Date: 2021/11/30 14:47
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {

    public User loginUser;//用户

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    RolePermissionService rolePermissionService;

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ResultVo<Object> login(String username, String password, String code, HttpServletRequest request) {
        // 验证码
        if (!validateCaptcha(code,request))
        {
            return ResultVo.error(CodeMsg.CODE_ERROR);
        }
        // 用户验证
        if (!validateUser(username,password,request))
        {
            return ResultVo.error(CodeMsg.USER_ERROR);
        }
        // 生成token
        String token = TokenUtils.token(username,password);
        //存放数据
        Map map = new HashMap();
        map.put("token", token);//token
        map.put("userInfo", getUserInfo(request));//用户所有信息
        return ResultVo.success(map);
    }

    /**
     * 获取用户信息
     * @param
     * @return
     */
    @Override
    public HashMap getUserInfo(HttpServletRequest request) {
        HashMap map = new HashMap();
        String loginUserId = (String) CacheUtils.getCache(CacheUtils.LoginUserId,request);//获取用户id缓存
        //用户基本信息
        User user = userMapper.selectByPrimaryKey(loginUserId);
        //角色
        UserRoleExample example = new UserRoleExample();
        example.setUid(loginUserId);
        List<UserRole> userRoleList = userRoleService.page(example);
        List<Role> roleList = new ArrayList<>();//角色集合
        HashSet<String> roleMenuIdsList = new HashSet();//角色菜单集合（自动去重）
        for(UserRole userRole:userRoleList){ //循环查询全部角色
            Role role = roleService.selectByPrimaryKey(userRole.getRid());
            List<String>  roleMenuList = rolePermissionService.selectPidByRid(userRole.getRid());
            roleList.add(role);//角色集合
            roleMenuIdsList.addAll(roleMenuList);//菜单集合
        }
        //权限菜单
        List<Permission> permissionList = permissionService.getPermissionTree();//查询全部菜单
        permissionList.removeIf(e -> ! roleMenuIdsList.contains(e.getId()) );//去除无权限菜单(一级)
        for(Permission permission:permissionList){//去除无权限菜单(二级)
            if(!permission.getChildMenus().isEmpty()){ //如果有子集
                permission.getChildMenus().removeIf(e -> ! roleMenuIdsList.contains(e.getId()) );//去除子集无权限菜单
            }
        }
        map.put("user", user);//用户
        map.put("role", roleList);//角色
        map.put("menu", permissionList);//权限菜单
        map.put("roleMenuIdsList", roleMenuIdsList);//权限菜单ids
        return map;
    }

    /**
     * 登出
     * @param
     * @return
     */
    @Override
    public ResultVo<Object> loginOut(HttpServletRequest request) {
        CacheUtils.removeCache(CacheUtils.LoginUserId,request);//清除用户id缓存
        return ResultVo.success("已退出");
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
    public boolean validateUser(String username, String password, HttpServletRequest request)
    {
        UserExample example = new UserExample();
        example.setUserName(username);
        example.setPassword(password);
        List<User> users = userMapper.selectByExample(example);
        if (users.size()>0) {
            CacheUtils.putCache(CacheUtils.LoginUserId,users.get(0).getId(),request);//放置用户id缓存
//            loginUser = users.get(0);//放置用户
            return true;
        }
        return false;
    }
}
