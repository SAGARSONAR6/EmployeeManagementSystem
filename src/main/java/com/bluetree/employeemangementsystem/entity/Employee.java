package com.bluetree.employeemangementsystem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue
	private Long employeeId;
	@Column(nullable = false)
	private String employeeName;
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String employeeMailId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate employeeDob;
	private Integer employeeAge;
	private Double employeeSalary;
	private Boolean employeeStatus;

}
