package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserDto;
import com.example.model.Users;
import com.example.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public List<Users> listUser(){
        return userService.findAll();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Users getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }


    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public Users saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }



}
