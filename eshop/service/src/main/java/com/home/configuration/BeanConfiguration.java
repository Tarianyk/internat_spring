package com.home.configuration;

import com.home.service.impl.IRoleService;
import com.home.service.impl.IUserService;
import com.home.service.RoleService;
import com.home.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IUserService getUserService() {
        return new UserService();
    }

    @Bean
    public IRoleService getRoleService() {
        return new RoleService();
    }
}
