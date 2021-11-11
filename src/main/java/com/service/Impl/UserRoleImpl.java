package com.service.Impl;

import com.dao.UserRoleMapper;
import com.domain.Example.UserRoleExample;
import com.domain.UserRole;
import com.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author: wangxm
 * @Date: 2021/11/10 10:26
 */
@Service
public class UserRoleImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> page(UserRoleExample example) {
        return userRoleMapper.selectByExample(example);
    }

    @Override
    public int insert(UserRole record) {
        record.setId(UUID.randomUUID().toString());
        return userRoleMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public UserRole selectByPrimaryKey(String id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }
}
