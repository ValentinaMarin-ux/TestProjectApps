package com.example.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.models.Movie;
import com.example.test.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Save a movie.
     *
     * @param movie the movie to save
     * @return the persisted movie
     */
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Get all movies.
     *
     * @return the list of movies
     */
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    /**
     * Get the movie by id.
     *
     * @param id the id of the movie to retrieve
     * @return the movie
     */
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    /**
     * Delete the movie by id.
     *
     * @param id the id of the movie to delete
     */
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    /**
     * Update an existing movie.
     *
     * @param id          The ID of the movie to update
     * @param newMovie    The new movie data
     * @return The updated movie
     */
    public Movie update(Long id, Movie newMovie) {
        Movie existingMovie = movieRepository.findById(id).orElse(null);
        
        if (existingMovie != null) {
            existingMovie.setName(newMovie.getName());
            existingMovie.setGenre(newMovie.getGenre());
            existingMovie.setReleaseYear(newMovie.getReleaseYear());
            existingMovie.setStock(newMovie.getStock());

            return movieRepository.save(existingMovie);
        }
        
        return null; 
    }
}
