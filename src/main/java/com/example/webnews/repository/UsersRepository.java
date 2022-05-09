package com.example.webnews.repository;

import com.example.webnews.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("select u from Users u where u.user_name = ?1 and u.password = ?1")
    Page<Users> login(String user_name,String password, Pageable pageable);


}
