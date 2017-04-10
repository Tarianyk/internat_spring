package com.home.web.controller;

import com.home.domain.User;
import com.home.service.IUserService;
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

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public String addUserToDatabase(@ModelAttribute("registration_bean") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveIntoDatabase(user);

        return "index";
    }

    @ModelAttribute(value = "registration_bean")
    public User init() {
        return new User();
    }
}
