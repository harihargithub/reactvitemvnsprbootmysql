package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmpRepository empRepository;

    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        String[] departments = { "HR", "Finance", "IT", "Sales" };

        IntStream.range(0, 10).forEach(i -> {
            Emp emp = new Emp();
            emp.setName("Employee " + (i + 1));
            emp.setDepartment(departments[random.nextInt(departments.length)]);
            emp.setSalary(30000 + (random.nextDouble() * 70000));
            empRepository.save(emp);
        });
    }
}