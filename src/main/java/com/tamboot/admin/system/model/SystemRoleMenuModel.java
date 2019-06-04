package com.tamboot.admin.system.model;

import com.tamboot.webapp.core.BaseModel;

public class SystemRoleMenuModel extends BaseModel {
    private static final long serialVersionUID = -2691232723896611382L;

    private String roleCode;

    private Long menuId;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
