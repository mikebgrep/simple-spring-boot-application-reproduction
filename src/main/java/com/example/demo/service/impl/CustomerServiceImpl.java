package com.example.demo.service.impl;


import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }



    @Override
    public Customer findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Customer with that id %d does not exists", id)));
    }

    @Override
    public Customer findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException(String.format("Customer with that email %s does not exists", email)));
    }


}
