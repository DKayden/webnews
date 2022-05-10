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

    private Page<Users> userPage = null;

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

    public Paged<Users> login (int pageNumber, int size, String user_name) {
        PageRequest request = PageRequest.of(pageNumber - 1, size);
        if (user_name != null) {
            userPage = usersRepository.login(user_name,request);
            return new Paged<>(userPage, Paging.of(userPage.getTotalPages(),pageNumber,size));
        }
        return new Paged<>(null, Paging.of(userPage.getTotalPages(), pageNumber, size));
    }

}
