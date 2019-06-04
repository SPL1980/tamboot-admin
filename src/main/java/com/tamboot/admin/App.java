package com.tamboot.admin;

import com.tamboot.admin.core.RoleBasedPermissionInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude ={QuartzAutoConfiguration.class})
@EnableTransactionManagement
@MapperScan("com.tamboot.admin.*.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.addListeners(new RoleBasedPermissionInitializer());
        app.run();
    }
}
