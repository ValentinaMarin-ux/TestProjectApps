package com.example.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.models.Fine;
import com.example.test.repository.FineRepository;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;

    /**
     * Save a fine.
     *
     * @param fine the fine to save
     * @return the persisted fine
     */
    public Fine save(Fine fine) {
        return fineRepository.save(fine);
    }

    /**
     * Get all fines.
     *
     * @return the list of fines
     */
    public List<Fine> findAll() {
        return fineRepository.findAll();
    }

    /**
     * Get the fine by id.
     *
     * @param id the id of the fine to retrieve
     * @return the fine
     */
    public Optional<Fine> findById(Long id) {
        return fineRepository.findById(id);
    }

    /**
     * Delete the fine by id.
     *
     * @param id the id of the fine to delete
     */
    public void deleteById(Long id) {
        fineRepository.deleteById(id);
    }

    /**
     * Update an existing fine.
     *
     * @param id       The ID of the fine to update
     * @param newFine  The new fine data
     * @return The updated fine
     */
    public Fine update(Long id, Fine newFine) {
        Fine existingFine = fineRepository.findById(id).orElse(null);
        
        if (existingFine != null) {
            existingFine.setAmount(newFine.getAmount());
            existingFine.setReason(newFine.getReason());
           

            return fineRepository.save(existingFine);
        }
        
        return null; 
    }
}
