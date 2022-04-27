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

    Page<News> findAll(Pageable pageable);

    @Query("select n from News n where n.title like %?1%"
            +"or n.author like %?1%")
    public List<News> searchByTitle(String keyword);

}