package com.example.employecrud.repository;

import com.example.employecrud.model.Bonus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BonusRepository extends MongoRepository<Bonus, String> {
}
