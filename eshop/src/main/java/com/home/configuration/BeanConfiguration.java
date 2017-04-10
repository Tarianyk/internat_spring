package com.home.configuration;

import com.home.service.UserService;
import com.home.service.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IUserService getUserService() {
        return new UserService();
    }
}
