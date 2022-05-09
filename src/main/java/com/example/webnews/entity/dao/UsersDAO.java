package com.example.webnews.entity.dao;

import com.example.webnews.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<Users,Integer> {
}
