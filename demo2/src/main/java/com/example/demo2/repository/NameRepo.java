package com.example.demo2.repository;

import com.example.demo2.model.People;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.lang.model.element.Name;

public interface NameRepo extends MongoRepository<People, String> {

}
