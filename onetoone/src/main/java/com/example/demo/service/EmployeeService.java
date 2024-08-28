package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDTO;

public interface EmployeeService {

	public EmployeeDTO save(EmployeeDTO dto);

//	public EmployeeDTO update(EmployeeDTO dto);

	public List<EmployeeDTO> get();

	public EmployeeDTO delete(Integer employeeId);

}
