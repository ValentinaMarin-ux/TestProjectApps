package com.example.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.models.Rental;
import com.example.test.repository.RentalRepository;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    /**
     * Save a rental.
     *
     * @param rental the rental to save
     * @return the persisted rental
     */
    public Rental save(Rental rental) {
        return rentalRepository.save(rental);
    }

    /**
     * Get all rentals.
     *
     * @return the list of rentals
     */
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    /**
     * Get the rental by id.
     *
     * @param id the id of the rental to retrieve
     * @return the rental
     */
    public Optional<Rental> findById(Long id) {
        return rentalRepository.findById(id);
    }

    /**
     * Delete the rental by id.
     *
     * @param id the id of the rental to delete
     */
    public void deleteById(Long id) {
        rentalRepository.deleteById(id);
    }

    /**
     * Update an existing rental.
     *
     * @param id          The ID of the rental to update
     * @param newRental   The new rental data
     * @return The updated rental
     */
    public Rental update(Long id, Rental newRental) {
        Rental existingRental = rentalRepository.findById(id).orElse(null);
        
        if (existingRental != null) {
            existingRental.setRentalDate(newRental.getRentalDate());
            existingRental.setReturnDate(newRental.getReturnDate());
            existingRental.setCustomer(newRental.getCustomer());
            existingRental.setMovie(newRental.getMovie());

            return rentalRepository.save(existingRental);
        }
        
        return null; 
    }
}
