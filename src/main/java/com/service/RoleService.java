package com.service;

import com.domain.Example.RoleExample;
import com.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/7/4 16:13
 */
@Service
public interface RoleService {
    /**
     * 分页查询
     */
    List<Role> page(RoleExample example);

    /**
     * 角色字典
     */
    List roleDict();

    /**
     * 新增
     */
    int insert(Role record);

    /**
     * 删除
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改
     */
    int updateByPrimaryKey(Role record);

    /**
     * id查询
     */
    Role selectByPrimaryKey(String id);
}
