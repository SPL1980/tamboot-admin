package com.tamboot.admin.common.controller;

import com.tamboot.admin.common.service.CommonMenuService;
import com.tamboot.admin.core.MenuTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/common/menu")
public class CommonMenuController {
    @Autowired
    private CommonMenuService commonMenuService;

    @GetMapping("/tree")
    public List<MenuTree> tree() {
        return commonMenuService.tree();
    }
}
