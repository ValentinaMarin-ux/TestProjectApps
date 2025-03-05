package com.example.test.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fines")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the fine

    @Column(nullable = false)
    private double amount; // Fine amount

    @Column(nullable = false, length = 255)
    private String reason; // Reason for the fine

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental; // Associated rental for which the fine was issued

    // Default constructor
    public Fine() {}

    // Constructor with parameters
    public Fine(double amount, String reason, Rental rental) {
        this.amount = amount;
        this.reason = reason;
        this.rental = rental;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
}
