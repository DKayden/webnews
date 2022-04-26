package com.example.webnews.entity.dao;

import com.example.webnews.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NewsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<News> newsList() {
        String sql = "SELECT * FROM news";

        List<News> newsList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(News.class));
        return newsList;
    }

}
