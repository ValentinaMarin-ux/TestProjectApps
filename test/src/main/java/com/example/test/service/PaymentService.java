package com.example.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.models.Payment;
import com.example.test.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * Save a payment.
     *
     * @param payment the payment to save
     * @return the persisted payment
     */
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    /**
     * Get all payments.
     *
     * @return the list of payments
     */
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    /**
     * Get the payment by id.
     *
     * @param id the id of the payment to retrieve
     * @return the payment
     */
    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }

    /**
     * Delete the payment by id.
     *
     * @param id the id of the payment to delete
     */
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }

    /**
     * Update an existing payment.
     *
     * @param id         The ID of the payment to update
     * @param newPayment The new payment data
     * @return The updated payment
     */
    public Payment update(Long id, Payment newPayment) {
        Payment existingPayment = paymentRepository.findById(id).orElse(null);
        
        if (existingPayment != null) {
            existingPayment.setAmount(newPayment.getAmount());
            existingPayment.setStatus(newPayment.getStatus());

            return paymentRepository.save(existingPayment);
        }
        
        return null; 
    }
}
