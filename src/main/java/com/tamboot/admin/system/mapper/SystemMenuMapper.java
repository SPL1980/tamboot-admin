package com.tamboot.admin.system.mapper;

import com.tamboot.admin.system.model.SystemMenuModel;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface SystemMenuMapper {
    int insert(SystemMenuModel model);

    int updateById(SystemMenuModel model);

    int deleteById(Long id);

    SystemMenuModel selectOneById(Long id);

    List<SystemMenuModel> selectAllByParent(Long parent);

    List<SystemMenuModel> selectAll();

    List<SystemMenuModel> selectAllByRoleCodes(@Param("roleCodes") Collection<String> roleCodes);

    List<Long> selectAllIdsByRoleCodes(@Param("roleCodes") Collection<String> roleCodes);

    List<SystemMenuModel> selectAllByIds(@Param("ids") List<Long> ids);
}
