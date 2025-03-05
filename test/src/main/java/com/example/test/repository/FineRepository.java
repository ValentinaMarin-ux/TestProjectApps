package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.models.Fine;


@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {
    


}   