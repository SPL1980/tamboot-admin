package com.tamboot.admin.system.mapper;

import com.tamboot.admin.system.model.SystemUserRoleModel;

import java.util.List;

public interface SystemUserRoleMapper {
    int insert(SystemUserRoleModel model);

    int deleteByRoleCode(String roleCode);

    int deleteByUserId(Long userId);

    List<SystemUserRoleModel> selectAllByUserId(Long userId);
}
