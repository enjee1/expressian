package com.expressian.app.controllers;

import com.expressian.app.models.Customer;
import com.expressian.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public @ResponseBody List<Customer> getCustomers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/lastname/{lname}")
    public ResponseEntity<List<Customer>> getCustomersByLastName(@PathVariable String lname) {
        return new ResponseEntity<>(repository.findAllByLastName(lname, Sort.by("firstName")), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        return new ResponseEntity<>(repository.save(newCustomer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updates) {
        Customer customer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getFirstName() != null) customer.setFirstName(updates.getFirstName());
        if (updates.getLastName() != null) customer.setLastName(updates.getLastName());
        if (updates.getAddress() != null) customer.setAddress(updates.getAddress());

        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
