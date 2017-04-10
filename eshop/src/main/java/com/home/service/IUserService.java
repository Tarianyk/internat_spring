package com.home.service;

import com.home.domain.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    void createUser(UserDto userDto);
}
