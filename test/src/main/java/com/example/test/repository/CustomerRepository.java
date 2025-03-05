package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.models.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
    


