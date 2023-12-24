package com.example.demo.service.impl;


import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import com.example.demo.service.CustomerService;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final CustomerService customerService;

    public UserServiceImpl(UserRepository repository, CustomerService customerService) {
        this.repository = repository;
        this.customerService = customerService;
    }

    @Override
    public User save(User user) {

        return repository.save(user);
    }


    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("User with that id %d does not found", id)));
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(String.format("user with email does not exits %s", email)));
    }


}
