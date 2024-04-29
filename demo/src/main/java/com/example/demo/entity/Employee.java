package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "passport_number")
    private String pasportNumber;
    @Column(name = "passport_date")
    private String pasportDate;
    @Column(name = "salary")
    private double salary;

    public Employee(Long id, String name, String surname, String pasportNumber, String pasportDate, double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pasportNumber = pasportNumber;
        this.pasportDate = pasportDate;
        this.salary = salary;
    }
    public Employee() {}

}
