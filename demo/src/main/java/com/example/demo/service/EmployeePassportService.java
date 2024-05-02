package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmployeePassportService {
    final private EmployeeRepository employeeRepository;
    public EmployeePassportService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public void editPassportData(Long id, String passportNumber, LocalDate passportDate){
        employeeRepository.updatePassportById(passportNumber, passportDate, id);
    }
}
