package com.bluetree.employeemangementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bluetree.employeemangementsystem.entity.Employee;
import com.bluetree.employeemangementsystem.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/homePage")
	public String landingPage(Model model) {
		model.addAttribute("listOfEmployees", employeeService.getAllEmployee());
		return "LandingPage";
	}

	@GetMapping("/addEmployee")
	public String addData(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "AddEmployee";

	}

	@PostMapping("/add")
	public String addDetails(@ModelAttribute("employee") Employee employee) {
		if (employee != null)
			employeeService.addDetails(employee);
		return "redirect:/homePage";
	}

	@GetMapping("/edit")
	public String name(@RequestParam(value = "id") Long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "UpdateEmployee";
	}

	@PostMapping({"/add","/update"})
	public String updateEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.addDetails(employee);
		return "redirect:/homePage";
	}

	@GetMapping("/delete")
	public String removeEmployee(@RequestParam(value = "id") Long id, Model model) {
		employeeService.removeEmployee(id);
		return "redirect:/homePage";
	}

}
