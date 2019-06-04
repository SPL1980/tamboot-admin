package com.tamboot.admin.system.mapper;

import com.tamboot.admin.system.model.SystemRoleMenuModel;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface SystemRoleMenuMapper {
    int insert(SystemRoleMenuModel model);

    int deleteByRoleCode(String roleCode);

    int deleteByMenuId(Long menuId);

    int deleteByIds(@Param("ids") Collection<Long> ids);

    List<SystemRoleMenuModel> selectAllByRoleCode(String roleCode);
}
