package com.example.webnews.controller;

import com.example.webnews.entity.News;
import com.example.webnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller

public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    @RequestMapping("/")
    public String paginate (@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                       @RequestParam(value = "size", required = false, defaultValue = "3") int size, Model model) {
        model.addAttribute("newsList",newsService.getPage(pageNumber,size));
        return "index";
    }

    @GetMapping
    @RequestMapping("/search")
    public String search (@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                          @RequestParam(value = "size",required = false,defaultValue = "3") int size,
                          @Param("keyword") String keyword, Model model) {
        List<News> newsList = newsService.listAll(keyword);
        model.addAttribute("newsList", newsList);
        model.addAttribute("keyword",keyword);

        return "index";
    }
}
