package com.example.webnews.controller;

import com.example.webnews.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    @RequestMapping("/{newsid}/comment")
    public String getListComments (@RequestParam(value = "pageNumber",required = false,defaultValue = "1")int pageNumber,
                                   @RequestParam(value = "size",required = false,defaultValue = "5") int size,
                                   @PathVariable("newsid") int newsid,
                                   Model model) {
        model.addAttribute("commentsList",commentService.listComment(pageNumber,size,newsid));
        model.addAttribute("user_name",commentService.getUserNameOfCommentByNewsId(newsid));
        model.addAttribute("newsid",newsid);

        return "comment";
    }
}
