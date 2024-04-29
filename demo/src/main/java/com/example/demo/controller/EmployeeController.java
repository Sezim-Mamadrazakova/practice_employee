package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeePassportService;
import com.example.demo.service.EmployeeSalaryService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeSalaryService employeeSalaryService;

    @Autowired
    private EmployeePassportService employeePassportService;
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.addEmployee(employee);
        if (savedEmployee != null) {
            return ResponseEntity.ok(savedEmployee);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/{id}/salary")
    public ResponseEntity<Employee> editSalary(@PathVariable Long id, @RequestParam double newSalary) {
        Employee updatedEmployee = employeeSalaryService.editSalary(id, newSalary);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}/passport")
    public ResponseEntity<Employee> editPassportData(@PathVariable Long id, @RequestParam String passportNumber, @RequestParam String passportDate) {
        Employee updatedEmployee = employeePassportService.editPassportData(id, passportNumber, passportDate);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
