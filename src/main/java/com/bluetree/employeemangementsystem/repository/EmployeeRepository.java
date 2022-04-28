package com.bluetree.employeemangementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluetree.employeemangementsystem.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByEmployeeName(String employeeName);
	
	
	
}
