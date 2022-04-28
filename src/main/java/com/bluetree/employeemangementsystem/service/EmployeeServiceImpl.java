package com.bluetree.employeemangementsystem.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetree.employeemangementsystem.entity.Employee;
import com.bluetree.employeemangementsystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public boolean addDetails(Employee employee) {
		Optional<Employee> findById = employeeRepository.findByEmployeeName(employee.getEmployeeName());
		if (findById.isPresent()) {
			findById.get().setEmployeeMailId(employee.getEmployeeMailId());
			findById.get().setEmployeeSalary(employee.getEmployeeSalary());
			return true;
		} else {
			employee.setEmployeeStatus(true);
			Period age = Period.between(employee.getEmployeeDob(), LocalDate.now());
			employee.setEmployeeAge(age.getYears());
			employeeRepository.save(employee);
			return true;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll.stream().filter(emp -> emp.getEmployeeStatus() == Boolean.TRUE).collect(Collectors.toList());
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		Optional<Employee> findById = employeeRepository.findById(empId);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new RuntimeException("Employee Not Found!!");
		}

	}

	@Override
	public void removeEmployee(Long id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			Employee employee = findById.get();
			employee.setEmployeeStatus(false);
			employeeRepository.save(employee);

		}
	}

//	@Override
//	public boolean updateDetails(Employee employee) {
//		Employee emp = new Employee();
//		BeanUtils.copyProperties(employee, emp);
//		employeeRepository.save(emp);
//		return true;
//	}
}
