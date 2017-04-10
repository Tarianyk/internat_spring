package com.home.service;

import com.home.domain.User;
import com.home.service.IUserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService implements IUserService {

    @Override
    public void saveIntoDatabase(User user) {
        System.out.print("WORK !!!!!");
    }
}
