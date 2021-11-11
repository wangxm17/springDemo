package com.service;

import com.domain.Example.UserRoleExample;
import com.domain.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/11/10 10:27
 */
@Service
public interface UserRoleService {
    /**
     * 分页查询
     */
    List<UserRole> page(UserRoleExample example);

    /**
     * 新增
     */
    int insert(UserRole record);

    /**
     * 删除
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改
     */
    int updateByPrimaryKey(UserRole record);

    /**
     * id查询
     */
    UserRole selectByPrimaryKey(String id);
}
