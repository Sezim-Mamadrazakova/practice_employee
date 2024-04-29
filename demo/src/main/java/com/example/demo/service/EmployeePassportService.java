package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EmployeePassportService {
    final private EmployeeRepository employeeRepository;
    public EmployeePassportService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Employee editPassportData(Long id, String passportNumber, String passportDate){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setPasportNumber(passportNumber);
            employee.setPasportDate(passportDate);
            return employeeRepository.save(employee);
        }
        else {
            return null;
        }
    }
}
