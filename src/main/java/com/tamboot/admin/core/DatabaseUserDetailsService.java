package com.tamboot.admin.core;

import com.tamboot.admin.constants.UserStatus;
import com.tamboot.admin.system.model.SystemUserModel;
import com.tamboot.admin.system.service.SystemRoleService;
import com.tamboot.admin.system.service.SystemUserService;
import com.tamboot.security.core.TambootUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {
    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private SystemRoleService systemRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUserModel user = systemUserService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }

        boolean isUserDisabled = (user.getStatus() == null || user.getStatus().equals(UserStatus.DISABLED));
        String[] roles = systemRoleService.findRolesForUser(user.getId());
        return TambootUserDetails
                .init(user.getId(), user.getUsername(), user.getPassword())
                .disabled(isUserDisabled)
                .roles(roles)
                .build();
    }
}
