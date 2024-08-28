package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/employee")
	public ResponseEntity<ResponseDTO> save(@RequestBody EmployeeDTO dto) {
		return ResponseEntity.ok(new ResponseDTO(false, "saved", service.save(dto)));
	}

//	@PutMapping("/update")
//	public ResponseEntity<ResponseDTO> update(@RequestBody EmployeeDTO dto){
//		return ResponseEntity.ok(new ResponseDTO(false,"saved", service.update(dto)));
//	}

	@GetMapping("/employees")
	public ResponseEntity<ResponseDTO> get() {
		return ResponseEntity.ok(new ResponseDTO(false, "employess details", service.get()));
	}

	@DeleteMapping("/delete/{employeeId}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer employeeId) {
		return ResponseEntity.ok(new ResponseDTO(false, "deleted successfully", service.delete(employeeId)));
	}

}
