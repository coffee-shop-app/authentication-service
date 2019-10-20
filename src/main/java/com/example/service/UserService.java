package com.example.service;

import java.util.List;

import com.example.model.UserDto;
import com.example.model.Users;

public interface UserService {

    Users save(UserDto user);
    List<Users> findAll();
    void delete(long id);
    Users findOne(String username);

    Users findById(Long id);
}
