package com.techno.demo.service;

import java.util.List;

import com.techno.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getData(Integer empId, String name, Integer salary, String designation);
	
}
