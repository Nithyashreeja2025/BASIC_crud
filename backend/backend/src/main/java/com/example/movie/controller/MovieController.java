package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                                   // every method returns JSON
@RequestMapping("/api/movies")                    // base URL for all methods below
@CrossOrigin(origins = "http://localhost:5173")   // allow the Vue app to call this server
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping                                   // GET /api/movies
    public List<Movie> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")                          // GET /api/movies/123
    public Movie getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping                                  // POST /api/movies
    public Movie create(@RequestBody Movie movie) {
        return service.create(movie);
    }

    @PutMapping("/{id}")                          // PUT /api/movies/123
    public Movie update(@PathVariable String id, @RequestBody Movie movie) {
        return service.update(id, movie);
    }

    @DeleteMapping("/{id}")                       // DELETE /api/movies/123
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
