package com.example.webnews.service;

import com.example.webnews.entity.News;
import com.example.webnews.entity.dao.NewsDAO;
import com.example.webnews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsDAO newsDAO;

    final private List<News> newsList = newsDAO.newsList();

    public Page<News> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<News> list;

        if (newsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, newsList.size());
            list = newsList.subList(startItem, toIndex);
        }
        Page<News> newsPage
                = new PageImpl<News>(list, PageRequest.of(currentPage, pageSize), newsList.size());

        return newsPage;
    }

    public List<News> findAll() {
        return newsRepository.findAll();
    }
    public Page<News> findPage(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber -1,5);
        return newsRepository.findAll(pageable);
    }
}
