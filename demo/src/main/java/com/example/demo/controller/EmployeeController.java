package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeePassportService;
import com.example.demo.service.EmployeeSalaryService;
import com.example.demo.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    private EmployeeSalaryService employeeSalaryService;

    private EmployeePassportService employeePassportService;
    public EmployeeController(EmployeeService employeeService, EmployeeSalaryService employeeSalaryService, EmployeePassportService employeePassportService){
        this.employeeService = employeeService;
        this.employeeSalaryService = employeeSalaryService;
        this.employeePassportService = employeePassportService;
    }
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
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }
    @PutMapping("/{id}/salary")
    public ResponseEntity<Employee> editSalary(@PathVariable Long id, @RequestParam double newSalary) {
        employeeSalaryService.editSalary(id, newSalary);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @PutMapping("/{id}/passport")
    public ResponseEntity<Employee> editPassportData(@PathVariable Long id, @RequestParam String passportNumber, @RequestParam LocalDate passportDate) {
        employeePassportService.editPassportData(id, passportNumber, passportDate);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
