package com.java.springxml.controller;

import com.java.springxml.entity.User;
import com.java.springxml.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/users")
    public String users(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

}
