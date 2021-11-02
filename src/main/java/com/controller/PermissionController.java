package com.controller;

import com.domain.Example.PermissionExample;
import com.domain.Permission;
import com.service.PermissionService;
import com.vo.ResultVo;
import com.vo.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Permission")
@Api(value = "PermissionController",description = "菜单模块(wxm)")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询")
    public TableDataInfo page(@RequestBody PermissionExample permissionExample){
        TableDataInfo.startPage(permissionExample.getPageNum(), permissionExample.getPageSize());
        return TableDataInfo.getDataTable(permissionService.page(permissionExample));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "新增")
    public ResultVo<Integer> insert(@RequestBody Permission permission){
        return ResultVo.success(permissionService.insert(permission));
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "删除")
    public ResultVo<Integer> deleteByPrimaryKey(@RequestBody Permission permission){
        return ResultVo.success(permissionService.deleteByPrimaryKey(permission.getId()));
    }

    @RequestMapping(value = "/updateByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    public ResultVo<Integer> updateByPrimaryKey(@RequestBody Permission permission){
        return ResultVo.success(permissionService.updateByPrimaryKey(permission));
    }

    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "id查询")
    public ResultVo selectByPrimaryKey(@RequestBody Permission permission){
        return ResultVo.success(permissionService.selectByPrimaryKey(permission.getId()));
    }

    @RequestMapping(value = "/getPermissionTree",method = RequestMethod.POST)
    @ApiOperation(value = "获取菜单树")
    public ResultVo getPermissionTree(){
        return ResultVo.success(permissionService.getPermissionTree());
    }

    @RequestMapping(value = "/getRouter",method = RequestMethod.POST)
    @ApiOperation(value = "获取路由")
    public ResultVo getRouter(){
        return ResultVo.success(permissionService.getRouter());
    }
}
