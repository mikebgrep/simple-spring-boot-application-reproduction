package com.example.demo;


import com.example.demo.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AccountServiceFuncTest {

    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerRepository repository;


    @Test
    public void verifyFindById() {
        Customer customer = Customer.builder().email("test@email.com").build();

        Customer expected = repository.save(customer);
        Customer actual = service.findById(expected.getId());

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getEmail(), actual.getEmail());
    }

    @Test
    public void verifyFindByEmail() {
        Customer customer = Customer.builder().email("test@email.com").build();
        Customer expected = repository.save(customer);
        Customer actual = service.findByEmail("test@email.com");

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getEmail(), actual.getEmail());
    }


    @Test
    public void verifySave() {
        Customer customer = Customer.builder().build();
        Customer expected = repository.save(customer);
        Customer actual = service.findById(expected.getId());

        assertTrue(Objects.nonNull(actual));
        assertTrue(actual.getId().equals(expected.getId()));
    }

}
