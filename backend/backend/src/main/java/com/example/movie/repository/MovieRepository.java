package com.example.movie.repository;

import com.example.movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

// Gives findAll(), findById(), save(), deleteById() with no code to write
public interface MovieRepository extends MongoRepository<Movie, String> {
}
