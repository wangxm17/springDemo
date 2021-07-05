package com.controller;

import com.domain.Example.RoleExample;
import com.domain.Role;
import com.service.RoleService;
import com.vo.ResultVo;
import com.vo.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangxm
 * @Date: 2021/7/4 16:21
 */
@RestController
@RequestMapping(value = "/Role")
@Api(value = "RoleController",description = "角色模块(wxm)")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询")
    public TableDataInfo page(@RequestBody RoleExample roleExample){
        TableDataInfo.startPage(roleExample.getPageNum(), roleExample.getPageSize());
        return TableDataInfo.getDataTable(roleService.page(roleExample));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "新增")
    public ResultVo<Integer> insert(@RequestBody Role role){
        return ResultVo.success(roleService.insert(role));
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "删除")
    public ResultVo<Integer> deleteByPrimaryKey(@RequestBody Role role){
        return ResultVo.success(roleService.deleteByPrimaryKey(role.getId()));
    }

    @RequestMapping(value = "/updateByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    public ResultVo<Integer> updateByPrimaryKey(@RequestBody Role role){
        return ResultVo.success(roleService.updateByPrimaryKey(role));
    }

    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "id查询")
    public ResultVo selectByPrimaryKey(@RequestBody Role role){
        return ResultVo.success(roleService.selectByPrimaryKey(role.getId()));
    }
}
