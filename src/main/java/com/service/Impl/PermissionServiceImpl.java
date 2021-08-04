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
    public List<Permission> getPermissionTree() {
        List<Permission> menuList = new ArrayList<Permission>(); //树集合
        List<Permission> menuAll = permissionMapper.selectFirstMenu(); //一级菜单
        for (Permission permission : menuAll) {
            List<Permission> ChildrenList = getChildrens(permission.getId());
            if(ChildrenList.size()>0){
                permission.setChildMenus(ChildrenList);
            }
            menuList.add(permission);
        }
        return menuList;
    }

    /**
     * 递归查询下级菜单
     */
    public List<Permission> getChildrens(Integer fatherId) {
        List<Permission> menuList = new ArrayList<Permission>(); //集合
        List<Permission> menuAll = permissionMapper.selectByFatherId(fatherId); //子集合
        for (Permission permission : menuAll) {
            System.out.println(permission);
            List<Permission> ChildrenList = getChildrens(permission.getId());
            if(ChildrenList.size()>0){
                permission.setChildMenus(ChildrenList);
            }
            menuList.add(permission);
        }
        return menuList;
    }

}
