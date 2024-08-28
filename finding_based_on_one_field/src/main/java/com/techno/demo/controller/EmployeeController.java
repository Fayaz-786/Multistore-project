package com.techno.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techno.demo.entity.Employee;
import com.techno.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> getData(@RequestParam(required = false) Integer empId, @RequestParam(required = false) String name,@RequestParam(required = false) Integer salary,@RequestParam(required = false) String designation ){
		return employeeService.getData(empId,name,salary,designation);
	}
}
