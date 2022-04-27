//package com.example.webnews.controller;
//
//import com.example.webnews.entity.News;
//import com.example.webnews.repository.NewsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//public class AppController {
//
//    @Autowired
//    private NewsDAO dao;
//
//    @Autowired
//    private NewsRepository newsRepository;
//
//    @RequestMapping("/")
//    public String viewHomePage(Model model) {
//        List<News> newsList = dao.newsList();
//        model.addAttribute("newsList",newsList);
//        return "index";
//    }
//}
