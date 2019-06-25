package com.tamboot.admin.system.mapper;

import com.github.pagehelper.Page;
import com.tamboot.admin.system.condition.PageUserCondition;
import com.tamboot.admin.system.dto.SystemUserDto;
import com.tamboot.admin.system.model.SystemUserModel;
import com.tamboot.mybatis.provider.CommonMapper;
import org.apache.ibatis.annotations.Param;

public interface SystemUserMapper extends CommonMapper<SystemUserModel, Long> {
    SystemUserModel selectOneByUsername(String username);

    Page<SystemUserDto> pageDtoByCondition(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("condition") PageUserCondition condition);
}
