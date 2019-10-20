package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
