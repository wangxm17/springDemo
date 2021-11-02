package com.service;

import com.domain.Example.PermissionExample;
import com.domain.Permission;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PermissionService {
    /**
     * 分页查询
     */
    List<Permission> page(PermissionExample permissionExample);

    /**
     * 新增
     */
    int insert(Permission permission);

    /**
     * 删除
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 修改
     */
    int updateByPrimaryKey(Permission record);

    /**
     * id查询
     */
    Permission selectByPrimaryKey(Integer id);

    /**
     * 获取菜单树
     */
    List<Permission> getPermissionTree();

    /**
     * 路由
     */
    List getRouter();
}
