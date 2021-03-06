package com.example.webnews.service;

import com.example.webnews.entity.Comments;
import com.example.webnews.entity.paging.Paged;
import com.example.webnews.entity.paging.Paging;
import com.example.webnews.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public String getUserNameOfCommentByNewsId (int newsid) {
        return commentRepository.getUserNameOfCommentByNewsId(newsid);
    }

    public List<Comments> listComment(int newsid) {
        List<Comments> commentsList = commentRepository.getCommentByNewsId(newsid);
        return commentsList;
    }
}
