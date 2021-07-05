package com.service.Impl;

import com.dao.UserMapper;
import com.domain.Example.UserExample;
import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> page(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    @Override
    public int insert(User user) {
        user.setCreateTime(new Date());
        return userMapper.insert(user);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        record.setUpdateTime(new Date());
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
