package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class EmpController {

    @Autowired
    private EmpRepository empRepository;

    @GetMapping("/api/employees")
    public List<Emp> getAllEmployees() {
        return empRepository.findAll();
    }
}