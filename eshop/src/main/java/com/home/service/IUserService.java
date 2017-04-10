package com.home.service;

import com.home.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    void saveIntoDatabase(User user);
}
