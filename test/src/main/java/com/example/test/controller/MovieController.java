package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.test.models.Movie;
import com.example.test.service.MovieService;

/**
 * REST Controller for managing movie-related endpoints.
 */
@RestController
@RequestMapping("/movie/v1/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Save a movie.
     *
     * @param movie the movie to save
     * @return the persisted movie
     */
    @PostMapping("/moviesave")
    public Movie saveMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }   

    /**
     * Get all movies.
     *
     * @return the list of movies
     */
    @GetMapping("/moviefindAll")
    public List<Movie> findAllMovies() {
        return movieService.findAll();
    }

    /**
     * Get a movie by id.
     *
     * @param id the id of the movie to retrieve
     * @return the movie
     */
    @GetMapping("/moviefindById/{id}")
    public Movie findMovieById(@PathVariable Long id) {
        return movieService.findById(id).orElse(null);
    }

    /**
     * Delete the movie by id.
     *
     * @param id the id of the movie to delete
     */
    @DeleteMapping("/moviedeleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }

    /**
     * Update an existing movie.
     *
     * @param id       The ID of the movie to update
     * @param newMovie The new movie data
     * @return The updated movie
     */
    @PutMapping("/movieupdate")
    public Movie update(@RequestBody Movie newMovie) {
        return movieService.update(newMovie.getId(), newMovie);
    }
}

