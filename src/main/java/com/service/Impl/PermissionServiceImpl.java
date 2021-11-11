package com.service.Impl;

import com.dao.PermissionMapper;
import com.domain.Example.PermissionExample;
import com.domain.Example.RoleExample;
import com.domain.Permission;
import com.domain.Role;
import com.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> page(PermissionExample example) {
        return permissionMapper.selectByExample(example);
    }

    @Override
    public List fatherDict() {
        List fatherList = new ArrayList();
        List<Permission> menuAll = permissionMapper.selectFirstMenu(); //一级菜单
        for (Permission permission:menuAll){
            Map<String,Object> map = new HashMap<>();
            map.put("id",permission.getId());
            map.put("fatherName",permission.getName());
            fatherList.add(map);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("id","'0");
        map.put("fatherName","(无)");
        fatherList.add(map);
        return fatherList;
    }

    @Override
    public int insert(Permission record) {
        record.setCreateTime(new Date());
        record.setId(UUID.randomUUID().toString());
        return permissionMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Permission record) {
        record.setUpdateTime(new Date());
        return permissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public Permission selectByPrimaryKey(String id) {
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
    public List getchildMenus(String fatherId) {
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
    public List<Permission> getChildrens(String fatherId) {
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
