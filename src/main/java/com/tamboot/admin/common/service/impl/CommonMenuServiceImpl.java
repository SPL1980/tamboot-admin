package com.tamboot.admin.common.service.impl;

import com.tamboot.admin.common.service.CommonMenuService;
import com.tamboot.admin.core.MenuTree;
import com.tamboot.admin.system.mapper.SystemMenuMapper;
import com.tamboot.admin.system.model.SystemMenuModel;
import com.tamboot.admin.system.service.SystemMenuService;
import com.tamboot.security.core.TambootUserDetails;
import com.tamboot.security.util.SafeSecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CommonMenuServiceImpl implements CommonMenuService {
    @Autowired
    private SystemMenuService systemMenuService;

    @Autowired
    private SystemMenuMapper systemMenuMapper;

    @Override
    public List<MenuTree> tree() {
        TambootUserDetails userDetails = SafeSecurityContextHolder.getUserDetails();
        if (CollectionUtils.isEmpty(userDetails.getRoles())) {
            return new ArrayList<MenuTree>(0);
        }

        List<SystemMenuModel> menus = systemMenuMapper.selectAllByRoleCodes(userDetails.getRoles());
        return systemMenuService.buildMenuTree(menus);
    }
}
