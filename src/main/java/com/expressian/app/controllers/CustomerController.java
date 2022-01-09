package com.expressian.app.controllers;

import com.expressian.app.models.Customer;
import com.expressian.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public @ResponseBody List<Customer> getCustomers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return repository.findById(customerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}