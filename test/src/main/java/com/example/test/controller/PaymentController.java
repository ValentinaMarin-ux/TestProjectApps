package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.test.models.Payment;
import com.example.test.service.PaymentService;

/**
 * REST Controller for managing payment-related endpoints.
 */
@RestController
@RequestMapping("/payment/v1/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * Save a payment.
     *
     * @param payment the payment to save
     * @return the persisted payment
     */
    @PostMapping("/paymentsave")
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }   

    /**
     * Get all payments.
     *
     * @return the list of payments
     */
    @GetMapping("/paymentfindAll")
    public List<Payment> findAllPayments() {
        return paymentService.findAll();
    }

    /**
     * Get a payment by id.
     *
     * @param id the id of the payment to retrieve
     * @return the payment
     */
    @GetMapping("/paymentfindById/{id}")
    public Payment findPaymentById(@PathVariable Long id) {
        return paymentService.findById(id).orElse(null);
    }

    /**
     * Delete the payment by id.
     *
     * @param id the id of the payment to delete
     */
    @DeleteMapping("/paymentdeleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        paymentService.deleteById(id);
    }

    /**
     * Update an existing payment.
     *
     * @param newPayment The new payment data
     * @return The updated payment
     */
    @PutMapping("/paymentupdate")
    public Payment update(@RequestBody Payment newPayment) {
        return paymentService.update(newPayment.getId(), newPayment);
    }
}

