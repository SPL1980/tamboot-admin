package com.tamboot.admin.system.mapper;

import com.github.pagehelper.Page;
import com.tamboot.admin.system.condition.PagePermissionCondition;
import com.tamboot.admin.system.model.SystemPermissionModel;
import com.tamboot.mybatis.provider.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemPermissionMapper extends CommonMapper<SystemPermissionModel, Long> {
    List<SystemPermissionModel> selectAll();

    SystemPermissionModel selectOneByUrl(String url);

    Page<SystemPermissionModel> pageByCondition(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("condition") PagePermissionCondition condition);
}
