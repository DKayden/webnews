package com.example.webnews.service;

import com.example.webnews.entity.Users;
import com.example.webnews.entity.paging.Paged;
import com.example.webnews.entity.paging.Paging;
import com.example.webnews.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    private Page<Users> userPage = null;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

//    public Paged<Users> getPage(int pageNumber, int size) {
//        PageRequest request = PageRequest.of(pageNumber - 1, size);
//        return Paged<>()
//    }

    public Paged<Users> login(int pageNumber, int size, String user_name, String password) {
        PageRequest request = PageRequest.of(pageNumber - 1, size);
        if (user_name != null) {
            userPage = usersRepository.login(user_name,password,request);
            return new Paged<>(userPage, Paging.of(userPage.getTotalPages(),pageNumber,size));
        }
        return new Paged<>(null,Paging.of(userPage.getTotalPages(), pageNumber, size));
    }
}
