package com.tamboot.admin.system.mapper;

import com.github.pagehelper.Page;
import com.tamboot.admin.system.condition.PagePermissionCondition;
import com.tamboot.admin.system.model.SystemPermissionModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemPermissionMapper {
    int insert(SystemPermissionModel model);

    int updateById(SystemPermissionModel model);

    int deleteById(Long id);

    List<SystemPermissionModel> selectAll();

    SystemPermissionModel selectOneByUrl(String url);

    SystemPermissionModel selectOneById(Long id);

    Page<SystemPermissionModel> pageByCondition(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("condition") PagePermissionCondition condition);
}
