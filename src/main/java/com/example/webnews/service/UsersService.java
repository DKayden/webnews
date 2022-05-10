package com.example.webnews.service;

import com.example.webnews.entity.Users;
import com.example.webnews.entity.paging.Paged;
import com.example.webnews.entity.paging.Paging;
import com.example.webnews.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> listAll() {
        return usersRepository.findAll();
    }

    public void save (Users user) {
        usersRepository.save(user);
    }

    public Users get(int id) {
        return usersRepository.findById(id).get();
    }

    public void delete (int id) {
        usersRepository.deleteById(id);
    }

}
