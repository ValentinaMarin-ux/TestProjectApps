package com.example.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.models.Customer;
import com.example.test.repository.CustomerRepository;

/**
 * Service class for managing pet-related operations.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Save a customer.
     *
     * @param customer the customer to save
     * @return the persisted customer
     */
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Get all customers.
     *
     * @return the list of customers
     */
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    /**
     * Get the customer by id.
     *
     * @param id the id of the customer to retrieve
     * @return the customer
     */
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * Delete the customer by id.
     *
     * @param id the id of the customer to delete
     */
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer update(Long id, Customer newCustomer) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        
        if (existingCustomer != null) {
            existingCustomer.setName(newCustomer.getName());
            existingCustomer.setEmail(newCustomer.getEmail());
            existingCustomer.setPhone(newCustomer.getPhone());

            return customerRepository.save(existingCustomer);
        }
        
        return null; 
    }
}