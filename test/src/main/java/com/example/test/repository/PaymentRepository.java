package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.example.test.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    


}   
