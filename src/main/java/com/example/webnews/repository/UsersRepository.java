package com.example.webnews.repository;

import com.example.webnews.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT * FROM USERS WHERE USER_NAME like '?1'", nativeQuery = true)
    Page<Users> login (String user_name, Pageable pageable);
}
