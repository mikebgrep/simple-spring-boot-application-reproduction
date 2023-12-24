package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User save (User entity);;


    User findById(Long id);

    User findByEmail(String email);


}
