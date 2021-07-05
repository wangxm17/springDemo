package com.service.Impl;

import com.dao.RoleMapper;
import com.domain.Example.RoleExample;
import com.domain.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/7/4 16:15
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<Role> page(RoleExample roleExample) {
        return roleMapper.selectByExample(roleExample);
    }

    @Override
    public int insert(Role role) {
        role.setCreateTime(new Date());
        return roleMapper.insert(role);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        record.setUpdateTime(new Date());
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public Role selectByPrimaryKey(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
