package com.expressian.app.repositories;

import com.expressian.app.models.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    Customer findByCustomer_id(Long id);
    List<Customer> findAllByLastName(String lastName, Sort sort);

    /*@Query("SELECT * FROM customer WHERE lastName = ?1 AND address = ?2")
    Customer findByLastNameAndAddress(Sort sort, String lastName, String address);*/
}
