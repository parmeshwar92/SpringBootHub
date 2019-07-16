package com.spring.crud.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.EmployeeManagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
