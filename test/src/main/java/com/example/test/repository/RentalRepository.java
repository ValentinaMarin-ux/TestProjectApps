package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.models.Rental;



@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    


}   
