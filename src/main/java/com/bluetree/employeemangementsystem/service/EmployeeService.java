package com.bluetree.employeemangementsystem.service;

import java.util.List;

import com.bluetree.employeemangementsystem.entity.Employee;

public interface EmployeeService {

	boolean addDetails(Employee employee);

//	boolean updateDetails(Employee employee);

	Employee getEmployeeById(Long empId);

	List<Employee> getAllEmployee();

	void removeEmployee(Long id);

}
