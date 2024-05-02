package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeSalaryService {
    private final EmployeeRepository employeeRepository;
    public EmployeeSalaryService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public void editSalary(Long id, double newSalary) {
        employeeRepository.updateSalaryById(newSalary, id);

    }
}
