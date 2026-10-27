package com.example.employecrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bonus")
@NoArgsConstructor
@AllArgsConstructor
public class Bonus {

    @Id
    private String id;

    private String empid;
    private double bonus;
    private String dept;
}