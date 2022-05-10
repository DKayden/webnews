package com.example.webnews.controller;

import com.example.webnews.entity.Users;
import com.example.webnews.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

//    @GetMapping("/register")
//    public String showForm(Model model) {
//        Users user = new Users();
//        model.addAttribute("user", user);
//
//        return "register_form";
//    }

    @RequestMapping("/users")
    public String viewHomePage(Model model) {
        List<Users> usersList = usersService.listAll();
        model.addAttribute("usersList",usersList);

        return "users";
    }

    @RequestMapping("/new")
    public String showFormAddNewUser(Model model) {
        Users user = new Users();
        model.addAttribute("user",user);
        return "new_user";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") Users user) {
        usersService.save(user);
        return "redirect:/users";
    }

//    @RequestMapping("/edit/{id}")
//    public
//    @PostMapping("/register")
//    public String submitForm(@ModelAttribute("user") Users user) {
//        System.out.println(user);
//        return "register_success";
//    }
}
