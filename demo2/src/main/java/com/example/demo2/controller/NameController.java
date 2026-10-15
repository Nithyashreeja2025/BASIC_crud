package com.example.demo2.controller;


import com.example.demo2.model.People;
import com.example.demo2.repository.NameRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/names")
public class NameController {

    private final NameRepo nameRepo;
    @PostMapping
    public People saveName(@RequestBody People name) {
        return nameRepo.save(name);
    }
    @GetMapping
    public List<People> getPeople() {
        return nameRepo.findAll();
    }
    @PutMapping("/{id}")
    public People updateName(@PathVariable String id, @RequestBody People name) {
        People names=nameRepo.findById(id).orElse(null);
    names.setName(name.getName());
    names.setEmail(name.getEmail());
    return nameRepo.save(names);
    }
    @DeleteMapping("/{id}")
    public String deleteName(@PathVariable String id) {
        nameRepo.deleteById(id);
        return  "Deleted";
    }

}
