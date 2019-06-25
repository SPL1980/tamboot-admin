package com.tamboot.admin.system.mapper;

import com.tamboot.admin.system.model.SystemUserRoleModel;
import com.tamboot.mybatis.provider.CommonMapper;

import java.util.List;

public interface SystemUserRoleMapper extends CommonMapper<SystemUserRoleModel, Long> {
    int deleteByRoleCode(String roleCode);

    int deleteByUserId(Long userId);

    List<SystemUserRoleModel> selectAllByUserId(Long userId);
}
