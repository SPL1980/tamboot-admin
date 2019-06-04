package com.tamboot.admin.core;

import com.tamboot.admin.system.service.SystemPermissionService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

public class RoleBasedPermissionInitializer implements ApplicationListener<ApplicationReadyEvent> {


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        SystemPermissionService systemPermissionService = AppContextHolder.get().getBean(SystemPermissionService.class);
        systemPermissionService.refresh();
    }
}
