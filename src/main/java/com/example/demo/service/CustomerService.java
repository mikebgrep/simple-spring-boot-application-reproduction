package com.example.demo.service;


import com.example.demo.model.Customer;

public interface CustomerService {

    Customer save(Customer customer);

    Customer findById(Long id);
    Customer findByEmail(String email);

}
