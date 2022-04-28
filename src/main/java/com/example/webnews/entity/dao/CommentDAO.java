package com.example.webnews.entity.dao;

import com.example.webnews.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comments, Integer> {
}
