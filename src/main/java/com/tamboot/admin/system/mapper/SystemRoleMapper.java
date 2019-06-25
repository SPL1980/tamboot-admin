package com.tamboot.admin.system.mapper;

import com.github.pagehelper.Page;
import com.tamboot.admin.system.condition.PageRoleCondition;
import com.tamboot.admin.system.model.SystemRoleModel;
import com.tamboot.mybatis.provider.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface SystemRoleMapper extends CommonMapper<SystemRoleModel, Long> {
    SystemRoleModel selectOneByRoleCode(String roleCode);

    Page<SystemRoleModel> pageByCondition(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("condition") PageRoleCondition condition);

    List<SystemRoleModel> selectAllByRoleCodes(@Param("roleCodes") Collection<String> roleCodes);

    List<SystemRoleModel> selectAll();
}
