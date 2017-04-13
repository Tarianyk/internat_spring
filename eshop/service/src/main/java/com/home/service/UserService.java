package com.home.service;

import com.home.domain.UserDto;
import com.home.repository.RoleRepository;
import com.home.repository.UserRepository;
import com.home.repository.entity.Role;
import com.home.repository.entity.User;
import com.home.service.impl.IUserService;
import com.home.util.PasswordEncode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository iUserReposiroty;
    @Autowired
    private RoleRepository roleRepository;

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

        List<Role> roles = roleRepository.findAll();
        user.setRoles(new HashSet<>(roles));

        return user;
    }

}
