package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate pasportDate;
    @Column(name = "salary")
    private double salary;



}
