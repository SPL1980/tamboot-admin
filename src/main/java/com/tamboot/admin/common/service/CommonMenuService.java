package com.tamboot.admin.common.service;

import com.tamboot.admin.core.MenuTree;

import java.util.List;

public interface CommonMenuService {
    /**
     * Build menu tree according to roles of login user
     * @return menu tree, never null
     */
    List<MenuTree> tree();
}
