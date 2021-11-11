package com.service.Impl;

import com.dao.RoleMapper;
import com.dao.UserMapper;
import com.dao.UserRoleMapper;
import com.domain.Example.UserExample;
import com.domain.Example.UserRoleExample;
import com.domain.Role;
import com.domain.User;
import com.domain.UserRole;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<User> page(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public int insert(User record) {
        record.setCreateTime(new Date());//创建时间
        record.setId(UUID.randomUUID().toString());//id生成
        //关联角色
        if(!record.getRoleIds().isEmpty()){
            List roleIds = record.getRoleIds();
            for(Object rid:roleIds){
                UserRole userRole = new UserRole();
                userRole.setId(UUID.randomUUID().toString());
                userRole.setUid(record.getId());
                userRole.setRid((String) rid);
                userRoleMapper.insert(userRole);
            }
        }
        return userMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        //关联角色
        userRoleMapper.deleteByUid(id);
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        record.setUpdateTime(new Date());
        //关联角色(先删除关联，再插入)
        userRoleMapper.deleteByUid(record.getId());
        if(!record.getRoleIds().isEmpty()){
            List roleIds = record.getRoleIds();
            for(Object rid:roleIds){
                UserRole userRole = new UserRole();
                userRole.setId(UUID.randomUUID().toString());
                userRole.setUid(record.getId());
                userRole.setRid((String) rid);
                userRoleMapper.insert(userRole);
            }
        }
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.setUid(id);
        List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
        List roleIds = new ArrayList<>();
        for(UserRole userRole:userRoleList){
            roleIds.add(userRole.getRid());
        }
        user.setRoleIds(roleIds);
        return user;
    }

}
