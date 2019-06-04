package com.tamboot.admin.system.model;

import com.tamboot.webapp.core.BaseModel;

public class SystemUserRoleModel extends BaseModel {
    private static final long serialVersionUID = -4789755781414265256L;

    private Long userId;

    private String roleCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
