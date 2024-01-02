package com.crud.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.practice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

} 