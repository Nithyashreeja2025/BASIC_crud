package com.example.employecrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetails {

    private String empid;
    private String name;
    private String dept;
    private double fullSal;
}