package com.example.webnews.repository;


import com.example.webnews.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query("select e from News e")
    Page<News> findNews(Pageable pageable);

    Page<News> findAll(Pageable pageable);

    Page<News> findByTitleContaining(String title, Pageable pageable);
}