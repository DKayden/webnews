package com.example.webnews.controller;

import com.example.webnews.entity.Users;
import com.example.webnews.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        Users user = new Users();
        model.addAttribute("user",user);
        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@ModelAttribute("user") Users user) {
        System.out.println(user);
        return "register_success";
    }
}
