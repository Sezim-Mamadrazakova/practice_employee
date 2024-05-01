package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeSalaryService {
    private final EmployeeRepository employeeRepository;
    public EmployeeSalaryService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee editSalary(Long id, double newSalary) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = optionalEmployee.get();
        employee.setId(id);
        employee.setSalary(newSalary);
        return employeeRepository.save(employee);

    }
}
