package com.controller;

import com.service.PermissionService;
import com.service.RoleService;
import com.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangxm
 * @Date: 2021/11/11 11:18
 */
@RestController
@RequestMapping(value = "/DictType")
@Api(value = "DictTypeController",description = "字典类型模块(wxm)")
public class DictTypeController {
    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/roleDict",method = RequestMethod.POST)
    @ApiOperation(value = "角色字典")
    public ResultVo roleDict(){
        return ResultVo.success(roleService.roleDict());
    }

    @RequestMapping(value = "/fatherDict",method = RequestMethod.POST)
    @ApiOperation(value = "父级字典")
    public ResultVo fatherDict(){
        return ResultVo.success(permissionService.fatherDict());
    }

    @RequestMapping(value = "/menuDict",method = RequestMethod.POST)
    @ApiOperation(value = "菜单字典")
    public ResultVo menuDict(){
        return ResultVo.success(permissionService.getPermissionTree());
    }
}
