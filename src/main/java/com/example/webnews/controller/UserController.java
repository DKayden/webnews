package com.example.webnews.controller;

import com.example.webnews.entity.Users;
import com.example.webnews.service.NewsService;
import com.example.webnews.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    private final UsersService usersService;

    private final NewsService newsService;

    @Autowired
    public UserController(UsersService usersService, NewsService newsService) {
        this.usersService = usersService;
        this.newsService = newsService;
    }


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

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_user");
        Users user = usersService.get(id);
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        usersService.delete(id);
        return "redirect:/users";
    }

    @RequestMapping("/login")
    public String showLoginPage(Model model) {
        Users user = new Users();
        model.addAttribute("user",user);
        return "login";
    }

    @RequestMapping("/loginResult")
    public String showLoginResultPage() {
        return "loginResult";

    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String checkLogin(@RequestParam String user_name,
                             @RequestParam String password,
                             @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                             @RequestParam(value = "size", required = false, defaultValue = "3") int size,
                             HttpServletRequest request,
                             Model model
                             ) {
        HttpSession session = request.getSession();
        if (usersService.login(user_name,password)) {
            session.setAttribute("user_name",usersService.getUserName(user_name));
            model.addAttribute("session",session);
            model.addAttribute("newsList", newsService.getPage(pageNumber, size));
            return "index";
        }
        else {
            return "redirect:login?error";
        }
    }

    @RequestMapping(value="/logout", method = RequestMethod.POST)
    public String checkLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:login?logout";
    }
}
