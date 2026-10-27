package com.example.employecrud.controller;

import com.example.employecrud.model.*;
import com.example.employecrud.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BonusRepository bonusRepository;

    // Add employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee e) {
        return employeeRepository.save(e);
    }

    // Add bonus
    @PostMapping("/bonuses")
    public Bonus addBonus(@RequestBody Bonus b) {
        return bonusRepository.save(b);
    }

    // Get combined employee details
    @GetMapping("/employees")
    public List<EmployeeDetails> getEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<Bonus> bonuses = bonusRepository.findAll();

        List<EmployeeDetails> result = new ArrayList<>();

        for (Employee e : employees) {
            for (Bonus b : bonuses) {

                if (e.getId() != null &&
                        e.getId().equals(b.getEmpid())) {

                    EmployeeDetails d = new EmployeeDetails();

                    d.setEmpid(e.getId());
                    d.setName(e.getName());
                    d.setDept(b.getDept());
                    d.setFullSal(e.getBaseSal() + b.getBonus());

                    result.add(d);
                }
            }
        }

        return result;
    }
}