package com.service.Impl;

import com.dao.RolePermissionMapper;
import com.domain.Example.RoleExample;
import com.domain.Example.RolePermissionExample;
import com.domain.Role;
import com.domain.RolePermission;
import com.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: wangxm
 * @Date: 2021/11/10 10:28
 */
@Service
public class RolePermissionImpl implements RolePermissionService {

    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermission> page(RolePermissionExample example) {
        return rolePermissionMapper.selectByExample(example);
    }

    @Override
    public int insert(RolePermission record) {
        record.setId(UUID.randomUUID().toString());
        return rolePermissionMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return rolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(RolePermission record) {
        return rolePermissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public RolePermission selectByPrimaryKey(String id) {
        return rolePermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String>  selectPidByRid(String rid) {
        return rolePermissionMapper.selectPidByRid(rid);
    }

    @Override
    public int editByRid(String rid, List<String> allPid) {
        //先删除原有，再添加
        rolePermissionMapper.deleteByRid(rid);
        for (String pid:allPid){
            RolePermission rolePermission = new RolePermission();
            rolePermission.setId(UUID.randomUUID().toString());
            rolePermission.setRid(rid);
            rolePermission.setPid(pid);
            rolePermissionMapper.insert(rolePermission);
        }
        return 0;
    }
}
