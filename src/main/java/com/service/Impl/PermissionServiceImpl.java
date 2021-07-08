package com.service.Impl;

import com.dao.PermissionMapper;
import com.dao.UserMapper;
import com.domain.Example.PermissionExample;
import com.domain.Example.UserExample;
import com.domain.Permission;
import com.domain.PermissionTree;
import com.domain.User;
import com.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> page(PermissionExample permissionExample) {
        return permissionMapper.selectByExample(permissionExample);
    }

    @Override
    public int insert(Permission permission) {
        permission.setCreateTime(new Date());
        return permissionMapper.insert(permission);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        record.setUpdateTime(new Date());
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public Permission selectByPrimaryKey(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> getPermissionTree(Integer id) {
        return null;
    }


}
