package com.example.webnews.controller;

import com.example.webnews.entity.News;
import com.example.webnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class NewsController {

    private final NewsService newsService;


    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @GetMapping
    @RequestMapping("/")
    public String index(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                        @RequestParam(value = "size", required = false, defaultValue = "3") int size, Model model) {
        model.addAttribute("newsList", newsService.getPage(pageNumber, size));
        return "index";
    }


    @GetMapping
    @RequestMapping("/search")
    public String search(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                         @RequestParam(value = "size", required = false, defaultValue = "3") int size,
                         @Param("keyword") String keyword,
                         Model model) {
        model.addAttribute("newsList", newsService.listAll(pageNumber, size, keyword));
        model.addAttribute("searchMessage", newsService.getNumberNews(keyword));
        model.addAttribute("keyword",keyword);
        return "searchResult";
    }



    @GetMapping
    @RequestMapping("/news-{id}")
    public String getOneNews(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                             @RequestParam(value = "size", required = false, defaultValue = "1") int size,
                             @PathVariable("id") int id,
                             Model model) {
        model.addAttribute("eachNewsList", newsService.eachNews(pageNumber, size, id));

        return "eachNews";
    }
}
