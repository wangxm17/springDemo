package com.service;

import com.domain.Example.RoleExample;
import com.domain.Example.RolePermissionExample;
import com.domain.RolePermission;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/11/10 10:27
 */
@Service
public interface RolePermissionService {
    /**
     * 分页查询
     */
    List<RolePermission> page(RolePermissionExample example);

    /**
     * 新增
     */
    int insert(RolePermission record);

    /**
     * 删除
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改
     */
    int updateByPrimaryKey(RolePermission record);

    /**
     * id查询
     */
    RolePermission selectByPrimaryKey(String id);

    /**
     * rid查询全部pid
     */
    List<String>  selectPidByRid(String rid);

    /**
     * 根据rid权限配置
     */
    int editByRid(String rid, List<String> allPid);
}
