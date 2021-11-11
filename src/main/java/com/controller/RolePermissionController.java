package com.controller;

import com.domain.Example.RolePermissionExample;
import com.domain.Role;
import com.domain.RolePermission;
import com.service.RolePermissionService;
import com.vo.ResultVo;
import com.vo.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/11/10 10:28
 */
/*@CrossOrigin  //解决跨域*/
@RestController
@RequestMapping(value = "/RolePermission")
@Api(value = "RolePermissionController",description = "角色权限模块(wxm)")
@EnableAutoConfiguration
public class RolePermissionController {
    @Autowired
    RolePermissionService rolePermissionService;

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询")
    public TableDataInfo page(@RequestBody RolePermissionExample rolePermissionExample){
        TableDataInfo.startPage(rolePermissionExample.getPageNum(), rolePermissionExample.getPageSize());
        return TableDataInfo.getDataTable(rolePermissionService.page(rolePermissionExample));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "新增")
    public ResultVo<Integer> insert(@RequestBody RolePermission rolePermission){
        return ResultVo.success(rolePermissionService.insert(rolePermission));
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "删除")
    public ResultVo<Integer> deleteByPrimaryKey(@RequestBody RolePermission rolePermission){
        return ResultVo.success(rolePermissionService.deleteByPrimaryKey(rolePermission.getId()));
    }

    @RequestMapping(value = "/updateByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    public ResultVo<Integer> updateByPrimaryKey(@RequestBody RolePermission rolePermission){
        return ResultVo.success(rolePermissionService.updateByPrimaryKey(rolePermission));
    }

    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "id查询")
    public ResultVo selectByPrimaryKey(@RequestBody RolePermission rolePermission){
        return ResultVo.success(rolePermissionService.selectByPrimaryKey(rolePermission.getId()));
    }

    @RequestMapping(value = "/selectPidByRid",method = RequestMethod.POST)
    @ApiOperation(value = "rid查询全部pid")
    public ResultVo selectPidByRid(@RequestParam String rid){
        return ResultVo.success(rolePermissionService.selectPidByRid(rid));
    }

    @RequestMapping(value = "/editByRid",method = RequestMethod.POST)
    @ApiOperation(value = "根据rid权限配置")
    public ResultVo editByRid(@RequestParam String rid , List<String> allPid){
        return ResultVo.success(rolePermissionService.editByRid(rid,allPid));
    }
}
