package com.expressian.app.repositories;

import com.expressian.app.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomer_id(Long id);
}
