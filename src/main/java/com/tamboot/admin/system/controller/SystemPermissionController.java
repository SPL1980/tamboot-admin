package com.tamboot.admin.system.controller;

import com.github.pagehelper.Page;
import com.tamboot.admin.system.dto.SystemPermissionDto;
import com.tamboot.admin.system.form.CreatePermissionForm;
import com.tamboot.admin.system.form.PagePermissionForm;
import com.tamboot.admin.system.form.UpdatePermissionForm;
import com.tamboot.admin.system.model.SystemPermissionModel;
import com.tamboot.admin.system.service.SystemPermissionService;
import com.tamboot.security.permission.RoleBasedPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/system/permission")
public class SystemPermissionController {
    @Autowired
    private SystemPermissionService systemPermissionService;

    @GetMapping("/page")
    public Page<SystemPermissionDto> page(@Valid PagePermissionForm form) {
        return systemPermissionService.pageDto(form);
    }

    @PostMapping("/create")
    public SystemPermissionModel create(@RequestBody @Valid CreatePermissionForm form) {
        return systemPermissionService.create(form);
    }

    @PostMapping("/update")
    public SystemPermissionModel update(@RequestBody @Valid UpdatePermissionForm form) {
        return systemPermissionService.update(form);
    }

    @PostMapping("/refresh")
    public List<RoleBasedPermission> refresh() {
        return systemPermissionService.refresh();
    }

    @PostMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return systemPermissionService.delete(id);
    }
}
