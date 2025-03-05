package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.models.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    


}   