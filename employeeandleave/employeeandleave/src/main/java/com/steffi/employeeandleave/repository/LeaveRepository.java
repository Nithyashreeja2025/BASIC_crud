package com.steffi.employeeandleave.repository;

import com.steffi.employeeandleave.model.Leave;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeaveRepository extends MongoRepository<Leave,String> {
}
