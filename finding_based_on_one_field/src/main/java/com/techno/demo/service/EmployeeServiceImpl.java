package com.techno.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.demo.entity.Employee;
import com.techno.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getData(Integer empId, String name, Integer salary, String designation) {
		return repo.findByEmpIdOrNameOrSalaryOrDesignation(empId, name, salary, designation);
		

}
}
