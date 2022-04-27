package com.example.webnews.entity.dao;

import com.example.webnews.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDAO extends JpaRepository<News, Integer> {
}
