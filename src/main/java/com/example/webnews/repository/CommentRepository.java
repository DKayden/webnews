package com.example.webnews.repository;

import com.example.webnews.entity.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comments, Integer> {

    @Query("select c from Comments c where c.newsid = ?1")
    Page<Comments> getCommentByNewsId(int newsid, Pageable pageable);
}
