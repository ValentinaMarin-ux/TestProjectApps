package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.test.models.Customer;

import com.example.test.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * REST Controller for managing pet-related endpoints.
 */
@RestController
@RequestMapping("/customer/v1/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    
    /**
     * Save a movie.
     *
     * @param movie the movie to save
     * @return the persisted movie
     */
    @PostMapping("/customersave")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }   

    /**
     * Get all movies.
     *
     * @return the list of movies
     */
    @GetMapping("/customerfindAll")
    @JsonIgnore
    public List<Customer> findAllCustomers() {
        return customerService.findAll();
    }

    
   

    /**
     * Delete the movie by id.
     *
     * @param id the id of the movie to delete
     */
    @DeleteMapping("/customerdeleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    /**
     * Update an existing movie.
     *
     * @param id          The ID of the movie to update
     * @param newMovie    The new movie data
     * @return The updated movie
     */
    @PutMapping("/customerupdate")
    public Customer update(@RequestBody Customer newCustomer) {
        return customerService.update(newCustomer.getId(), newCustomer);
    }
}
