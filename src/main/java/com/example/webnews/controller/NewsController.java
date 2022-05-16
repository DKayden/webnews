package com.example.webnews.controller;

import com.example.webnews.service.CommentService;
import com.example.webnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class NewsController {

    private final NewsService newsService;

    private final CommentService commentService;


    @Autowired
    public NewsController(NewsService newsService, CommentService commentService) {
        this.newsService = newsService;
        this.commentService = commentService;
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
        model.addAttribute("commentsList",commentService.listComment(id));
        model.addAttribute("user_name",commentService.getUserNameOfCommentByNewsId(id));

        return "eachNews";
    }
}
