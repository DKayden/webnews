package com.example.webnews.service;

import com.example.webnews.entity.News;
import com.example.webnews.entity.dao.NewsDAO;
import com.example.webnews.entity.paging.Paged;
import com.example.webnews.entity.paging.Paging;
import com.example.webnews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    private final NewsDAO newsDAO;

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsDAO newsDAO, NewsRepository newsRepository) {
        this.newsDAO = newsDAO;
        this.newsRepository = newsRepository;
    }

    public Paged<News> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<News> newsPage = newsDAO.findAll(request);
        return new Paged<>(newsPage, Paging.of(newsPage.getTotalPages(), pageNumber, size));
    }
    public Paged<News> listAll(int pageNumber, int size, String keyword) {
        Page<News> newsPage = null;
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.by(Sort.Direction.DESC, "id"));
        if (keyword != null) {
            newsPage = newsRepository.searchByTitle(keyword,request);
            return new Paged<>(newsPage,Paging.of(newsPage.getTotalPages(), pageNumber, size));
        }
        return new Paged<>(null, Paging.of(newsPage.getTotalPages(), pageNumber, size));
    }

    public Paged<News> eachNews(int pageNumber, int size, int id) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<News> newsPage = newsRepository.getNewsById(id,request);
        return new Paged<>(newsPage,Paging.of(newsPage.getTotalPages(),pageNumber,size));
    }
}