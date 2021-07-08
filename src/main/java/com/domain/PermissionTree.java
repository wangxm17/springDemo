package com.domain;

import java.util.List;
/*菜单树实体*/
public class PermissionTree extends Permission{

    private List<Permission> children;

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }
}
