package com.service.Impl;

import com.dao.UserDao;
import com.domain.User;
import com.service.UserService;
import com.vo.CodeMsg;
import com.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public ResultVo getAllUsers() {
        List<User> allUsers = userDao.getAllUsers();
        if(allUsers.size()==0){
            return ResultVo.error(CodeMsg.SELECT_ERROR);
        }else{
            return ResultVo.success(allUsers);
        }
    }
}
