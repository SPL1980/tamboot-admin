package com.tamboot.admin.common.controller;

import com.tamboot.admin.common.form.UpdatePasswordForm;
import com.tamboot.admin.common.service.CommonUserService;
import com.tamboot.security.core.TambootUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/common/user")
public class CommonUserController {
    @Autowired
    private CommonUserService commonUserService;

    @GetMapping("/details")
    public TambootUserDetails details() {
        return commonUserService.details();
    }

    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody @Valid UpdatePasswordForm form) {
        commonUserService.updatePassword(form);
    }
}
