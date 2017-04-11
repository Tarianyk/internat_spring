package com.home.service;

import com.home.domain.UserDto;
import com.home.repository.IUserRepository;
import com.home.repository.entity.Role;
import com.home.repository.entity.User;
import com.home.util.PasswordEncode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class UserService implements IUserService {

    @Autowired
//    @Resource(name = "test")
    private IUserRepository iUserReposiroty;

    @Override
    public void createUser(UserDto userDto) {
        User user = extractToUser(userDto);
        iUserReposiroty.save(user);
    }

    private User extractToUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        String encodedPass = PasswordEncode.encodePassword(userDto.getPassword());
        user.setPassword(encodedPass);

        return user;
    }

    private Set<Role> getDefaultRole() {
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
//        role.setId();
        return null;
    }
}
