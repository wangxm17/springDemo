package com.controller;

import com.domain.Example.UserExample;
import com.domain.User;
import com.service.UserService;
import com.vo.ResultVo;
import com.vo.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:43
 */
/*@CrossOrigin  //解决跨域*/
@RestController
@RequestMapping(value = "/User")
@Api(value = "UserController",description = "用户模块(wxm)")
@EnableAutoConfiguration
public class UserController{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "分页查询")
    public TableDataInfo page(@RequestBody UserExample userExample){
        TableDataInfo.startPage(userExample.getPageNum(), userExample.getPageSize());
        return TableDataInfo.getDataTable(userService.page(userExample));
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "新增")
    public ResultVo<Integer> insert(@RequestBody User user){
        return ResultVo.success(userService.insert(user));
    }

    @RequestMapping(value = "/deleteByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "删除")
    public ResultVo<Integer> deleteByPrimaryKey(@RequestBody User user){
        return ResultVo.success(userService.deleteByPrimaryKey(user.getId()));
    }

    @RequestMapping(value = "/updateByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "修改")
    public ResultVo<Integer> updateByPrimaryKey(@RequestBody User user){
        return ResultVo.success(userService.updateByPrimaryKey(user));
    }

    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.POST)
    @ApiOperation(value = "id查询")
    public ResultVo selectByPrimaryKey(@RequestBody User user){
        return ResultVo.success(userService.selectByPrimaryKey(user.getId()));
    }

}
