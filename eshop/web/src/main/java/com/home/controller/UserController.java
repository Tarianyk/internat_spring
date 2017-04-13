package com.home.controller;

import com.home.domain.UserDto;
import com.home.service.impl.IRoleService;
import com.home.service.impl.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String addUserToDatabase(@ModelAttribute("registration_bean") @Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        createRoles();

        userService.createUser(userDto);

        return "index";
    }

    private void createRoles() {
        if (!roleService.checkRoles()) {
            roleService.createRoles();
        }
    }

    @ModelAttribute(value = "registration_bean")
    public UserDto init() {
        return new UserDto();
    }
}
