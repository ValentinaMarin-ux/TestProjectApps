package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.test.models.Rental;
import com.example.test.service.RentalService;

/**
 * REST Controller for managing rental-related endpoints.
 */
@RestController
@RequestMapping("/rental/v1/")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    /**
     * Save a rental.
     *
     * @param rental the rental to save
     * @return the persisted rental
     */
    @PostMapping("/rentalsave")
    public Rental saveRental(@RequestBody Rental rental) {
        return rentalService.save(rental);
    }   

    /**
     * Get all rentals.
     *
     * @return the list of rentals
     */
    @GetMapping("/rentalfindAll")
    public List<Rental> findAllRentals() {
        return rentalService.findAll();
    }

    /**
     * Get a rental by id.
     *
     * @param id the id of the rental to retrieve
     * @return the rental
     */
    

    /**
     * Delete the rental by id.
     *
     * @param id the id of the rental to delete
     */
    @DeleteMapping("/rentaldeleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        rentalService.deleteById(id);
    }

    /**
     * Update an existing rental.
     *
     * @param newRental The new rental data
     * @return The updated rental
     */
    @PutMapping("/rentalupdate")
    public Rental update(@RequestBody Rental newRental) {
        return rentalService.update(newRental.getId(), newRental);
    }
}

