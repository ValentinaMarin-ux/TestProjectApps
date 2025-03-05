
package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.test.models.Fine;
import com.example.test.service.FineService;

/**
 * REST Controller for managing fine-related endpoints.
 */
@RestController
@RequestMapping("/fine/v1/")
public class FineController {

    @Autowired
    private FineService fineService;

    /**
     * Save a fine.
     *
     * @param fine the fine to save
     * @return the persisted fine
     */
    @PostMapping("/finesave")
    public Fine saveFine(@RequestBody Fine fine) {
        return fineService.save(fine);
    }   

    /**
     * Get all fines.
     *
     * @return the list of fines
     */
    @GetMapping("/finefindAll")
    public List<Fine> findAllFines() {
        return fineService.findAll();
    }

    /**
     * Get a fine by id.
     *
     * @param id the id of the fine to retrieve
     * @return the fine
     */
    @GetMapping("/finefindById/{id}")
    public Fine findFineById(@PathVariable Long id) {
        return fineService.findById(id).orElse(null);
    }

    /**
     * Delete the fine by id.
     *
     * @param id the id of the fine to delete
     */
    @DeleteMapping("/finefindById/{id}")
    public void deleteById(@PathVariable Long id) {
        fineService.deleteById(id);
    }

    /**
     * Update an existing fine.
     *
     * @param newFine The new fine data
     * @return The updated fine
     */
    @PutMapping("/fineupdate")
    public Fine update(@RequestBody Fine newFine) {
        return fineService.update(newFine.getId(), newFine);
    }
}
