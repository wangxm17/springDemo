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
    List<Permission> page(PermissionExample example);

    /**
     * 父级字典
     */
    List fatherDict();

    /**
     * 新增
     */
    int insert(Permission record);

    /**
     * 删除
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改
     */
    int updateByPrimaryKey(Permission record);

    /**
     * id查询
     */
    Permission selectByPrimaryKey(String id);

    /**
     * 获取菜单树(全部)
     */
    List<Permission> getPermissionTree();

    /**
     * 路由
     */
    List getRouter();
}
