package com.example.webnews.controller;

import com.example.webnews.repository.NewsRepository;
import com.example.webnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class NewsController {

    private final NewsService newsService;

    private final NewsRepository newsRepository;

    @Autowired
    public NewsController(NewsService newsService, NewsRepository newsRepository) {
        this.newsService = newsService;
        this.newsRepository = newsRepository;
    }


    @GetMapping
    @RequestMapping("/")
    public String paginate(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
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
        model.addAttribute("newsListSearch", newsService.listAll(pageNumber, size, keyword));
        model.addAttribute("searchMessage", newsService.getNumberNews(keyword));
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
