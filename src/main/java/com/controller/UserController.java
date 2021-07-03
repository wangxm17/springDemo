package com.controller;

import com.service.UserService;
import com.vo.ResultVo;
import com.vo.TableDataInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:43
 */
/*@CrossOrigin  //解决跨域*/
@RestController
@RequestMapping(value = "/try")
@Api(value = "UserController",description = "用户模块(wxm)")
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息")
    public ResultVo getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/page",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息表格")
    public TableDataInfo page(){
        return TableDataInfo.getDataTable(userService.page());
//        return ResultVo.success(TableDataInfo.getDataTable(userService.page()));
    }

}
