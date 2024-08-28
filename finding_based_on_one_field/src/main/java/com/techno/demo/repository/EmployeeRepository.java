package com.techno.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	 List<Employee> findByEmpIdOrNameOrSalaryOrDesignation(Integer empId, String name, Integer salary, String designation);

}
