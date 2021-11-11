package com.service.Impl;

import com.dao.RoleMapper;
import com.domain.Example.RoleExample;
import com.domain.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: wangxm
 * @Date: 2021/7/4 16:15
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> page(RoleExample example) {
        return roleMapper.selectByExample(example);
    }

    @Override
    public List roleDict() {
        List roleList = new ArrayList();
        RoleExample example = new RoleExample();
        List<Role> roleAll = roleMapper.selectByExample(example);
        for (Role role:roleAll){
            Map<String,Object> map = new HashMap<>();
            map.put("id",role.getId());
            map.put("roleName",role.getRoleName());
            roleList.add(map);
        }
        return roleList;
    }

    @Override
    public int insert(Role record) {
        record.setCreateTime(new Date());
        record.setId(UUID.randomUUID().toString());
        return roleMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        record.setUpdateTime(new Date());
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public Role selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
