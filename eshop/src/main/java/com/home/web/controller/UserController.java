package com.home.web.controller;

import com.home.domain.UserDto;
import com.home.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String addUserToDatabase(@ModelAttribute("registration_bean") @Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.createUser(userDto);

        return "index";
    }

    @ModelAttribute(value = "registration_bean")
    public UserDto init() {
        return new UserDto();
    }
}
