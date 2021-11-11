package com.controller;

import com.domain.Example.UserExample;
import com.domain.Example.UserRoleExample;
import com.domain.User;
import com.domain.UserRole;
import com.service.UserRoleService;
import com.service.UserService;
import com.vo.ResultVo;
import com.vo.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangxm
 * @Date: 2021/11/10 10:25
 */
/*@CrossOrigin  //解决跨域*/
@RestController
@RequestMapping(value = "/UserRole")
@Api(value = "UserRoleController",description = "用户角色模块(wxm)")
@EnableAutoConfiguration
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询")
    public TableDataInfo page(@RequestBody UserRoleExample userRoleExample){
        TableDataInfo.startPage(userRoleExample.getPageNum(), userRoleExample.getPageSize());
        return TableDataInfo.getDataTable(userRoleService.page(userRoleExample));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "新增")
    public ResultVo<Integer> insert(@RequestBody UserRole userRole){
        return ResultVo.success(userRoleService.insert(userRole));
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "删除")
    public ResultVo<Integer> deleteByPrimaryKey(@RequestBody UserRole userRole){
        return ResultVo.success(userRoleService.deleteByPrimaryKey(userRole.getId()));
    }

    @RequestMapping(value = "/updateByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    public ResultVo<Integer> updateByPrimaryKey(@RequestBody UserRole userRole){
        return ResultVo.success(userRoleService.updateByPrimaryKey(userRole));
    }

    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "id查询")
    public ResultVo selectByPrimaryKey(@RequestBody UserRole userRole){
        return ResultVo.success(userRoleService.selectByPrimaryKey(userRole.getId()));
    }

}
