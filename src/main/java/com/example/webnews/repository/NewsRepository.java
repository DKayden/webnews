package com.example.webnews.repository;


import com.example.webnews.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {


    Page<News> findAll(Pageable pageable);

    @Query("select n from News n where n.title like %?1% or n.author like %?1% or n.content like %?1%")
    Page<News> search(String keyword, Pageable pageable);

    @Query(value = "select count(*) from (select * from News where title like %?1% or content like %?1% or author like %?1%)", nativeQuery = true)
    long getNumberNews(String keyword);


    @Query("select n from News n where n.id = ?1")
    Page<News> getNewsById(int id, Pageable pageable);

}