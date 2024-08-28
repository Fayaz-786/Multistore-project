package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO save(EmployeeDTO dto) {
		Optional<Employee> findByEmployeeId = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (findByEmployeeId.isEmpty()) {

			Employee emp = new Employee();
			BeanUtils.copyProperties(dto, emp);
			DepartmentDTO departments = dto.getDepartments();
			Department dept = new Department();
			BeanUtils.copyProperties(departments, dept);
			emp.setDepartments(dept);
			Employee save = employeeRepository.save(emp);
			BeanUtils.copyProperties(save, dto);
			return dto;
		} else {
			Employee employee = findByEmployeeId.get();
			BeanUtils.copyProperties(dto, employee);
			DepartmentDTO departments = dto.getDepartments();
			Department dept = new Department();
			BeanUtils.copyProperties(departments, dept);
			employee.setDepartments(dept);
			Employee save = employeeRepository.save(employee);
			BeanUtils.copyProperties(save, dto);
			return dto;
		}
	}

//	@Override
//	public EmployeeDTO update(EmployeeDTO dto) {
//		Optional<Employee> findById = employeeRepository.findById(dto.getEmployeeId());
//		if (findById.isPresent()) {
//			Employee employee = findById.get();
//			BeanUtils.copyProperties(dto, employee);
//			Department departments = employee.getDepartments();
//			employee.setDepartments(departments);
//			Employee save = employeeRepository.save(employee);
//			BeanUtils.copyProperties(save, dto);
//			return dto;
//		}
//		return null;
//	}

	@Override
	public List<EmployeeDTO> get() {
		List<Employee> findAll = employeeRepository.findAll();
		List<EmployeeDTO> list = new ArrayList<>();
      if(!findAll.isEmpty()) {
		findAll.forEach(i -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(i, employeeDTO);
			Department departments = i.getDepartments();
			DepartmentDTO deptDTO = new DepartmentDTO();
			BeanUtils.copyProperties(departments, deptDTO);
			employeeDTO.setDepartments(deptDTO);
			list.add(employeeDTO);
		});
		
	}
      return list;
      
	}
	@Override
	public EmployeeDTO delete(Integer employeeId) {
		Optional<Employee> findById = employeeRepository.findById(employeeId);
		if (findById.isPresent()) {
			employeeRepository.deleteById(employeeId);

		}
		return new EmployeeDTO();
	}
}
