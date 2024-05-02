package com.example.demo.repository;

import com.example.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Transactional
    @Modifying
    @Query("update Employee e set e.salary = ?1 where e.id = ?2")
    void updateSalaryById(double salary, Long id);

    @Transactional
    @Modifying
    @Query("update Employee e set e.pasportNumber = ?1, e.pasportDate = ?2 where e.id = ?3")
    void updatePassportById(String passportNumber, LocalDate passportDate, Long id);
}
