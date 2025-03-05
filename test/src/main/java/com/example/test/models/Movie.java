package com.example.test.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // Marks this class as a JPA entity (mapped to a database table)
@Table(name = "movies") // Specifies the table name in the database
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; // Unique identifier for each movie, auto-generated by the database

    @Column(nullable = false, length = 100)
    private String name; // Movie title, cannot be null, max length 100 characters

    @Column(nullable = false, length = 50)
    private String genre; // Genre of the movie (e.g., Action, Comedy), max length 50 characters

    @Column(nullable = false)
    private int releaseYear; // The year the movie was released

    @Column(nullable = false)
    private int stock; // Number of copies available in stock for rental

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // Prevents serialization of rentals to avoid infinite recursion in JSON responses
    private List<Rental> rentals; // List of rentals associated with this movie

    // Default constructor (needed for JPA)
    public Movie() {}

    // Constructor with parameters to initialize a Movie object
    public Movie(String name, String genre, int releaseYear, int stock) {
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stock = stock;
    }

    // Getters and Setters (used to access and modify private fields)
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }
}
