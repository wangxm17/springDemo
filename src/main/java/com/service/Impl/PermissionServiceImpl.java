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

import java.util.*;

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
    public List getRouter() {
        List  menuList = new ArrayList<>(); //树集合
        List<Permission> menuAll = permissionMapper.selectFirstMenu(); //一级菜单
        for (Permission permission : menuAll) {
            List ChildrenList = getchildMenus(permission.getId());
            Map map = new HashMap();
            map.put("path", permission.getPath());
            map.put("name", permission.getName());
            map.put("component", permission.getUrl());
            if(ChildrenList.size()>0){
                map.put("children", ChildrenList);
            }
            menuList.add(map);
        }
        return menuList;
    }

    /**
     * 递归查询下级路由
     */
    public List getchildMenus(Integer fatherId) {
        List menuList = new ArrayList<>(); //集合
        List<Permission> menuAll = permissionMapper.selectByFatherId(fatherId); //子集合
        for (Permission permission : menuAll) {
            System.out.println(permission);
            List<Permission> ChildrenList = getchildMenus(permission.getId());
            Map map = new HashMap();
            map.put("path", permission.getPath());
            map.put("name", permission.getName());
            map.put("component", permission.getUrl());
            if(ChildrenList.size()>0){
                map.put("children", ChildrenList);
            }
            menuList.add(map);
        }
        return menuList;
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
