package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    // Spring passes the repository in automatically (constructor injection)
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> getAll() {
        return repository.findAll();                      // READ all
    }

    public Movie getById(String id) {
        return repository.findById(id).orElse(null);      // READ one, or null if not found
    }

    public Movie create(Movie movie) {
        return repository.save(movie);                    // CREATE: no id, so it inserts
    }

    public Movie update(String id, Movie movie) {
        movie.setId(id);                                  // use the id from the URL
        return repository.save(movie);                    // UPDATE: id exists, so it replaces
    }

    public void delete(String id) {
        repository.deleteById(id);                        // DELETE
    }
}
