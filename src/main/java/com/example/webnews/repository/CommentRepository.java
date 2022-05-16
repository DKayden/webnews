package com.example.webnews.repository;

import com.example.webnews.entity.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Integer> {

//    @Query(value = "select * from comments where newsid = ?1", nativeQuery = true)
//    Page<Comments> getCommentByNewsId(int newsid, Pageable pageable);
//    @Query(value = "select * from comments where newsid = ?1", nativeQuery = true)
    @Query("select c from Comments c where c.newsid = ?1")
    List<Comments> getCommentByNewsId(int newsid);

//    @Query(value = "SELECT USER_NAME FROM COMMENTS JOIN USERS ON COMMENTS.usersid = USERS.id WHERE NEWSID = ?1", nativeQuery = true)
//    String getUserNameOfCommentByNewsId(int newsid);

    @Query("select u.user_name from Comments c join Users u on c.usersid = u.id where c.newsid = ?1")
    String getUserNameOfCommentByNewsId(int newsid);
}
