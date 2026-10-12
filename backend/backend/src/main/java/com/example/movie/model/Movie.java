package com.example.movie.model;

import org.springframework.data.annotation.Id;                 // marks the unique key field
import org.springframework.data.mongodb.core.mapping.Document; // links the class to a collection

@Document(collection = "movies")   // each Movie object is stored as one record in "movies"
public class Movie {

    @Id                            // MongoDB generates this value automatically
    private String id;
    private String title;
    private String genre;

    // getters and setters: Spring uses them to convert between JSON and this object
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}
