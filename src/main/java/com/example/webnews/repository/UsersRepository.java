package com.example.webnews.repository;

import com.example.webnews.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * FROM USERS WHERE USER_NAME like ?1", nativeQuery = true)
    Users checkUserName(String user_name);
}