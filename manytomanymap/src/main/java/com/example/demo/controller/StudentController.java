package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
     
	@Autowired
	private StudentService service;
	
	@PostMapping("/student")
	
	public ResponseEntity<ResponseDTO> save(@RequestBody StudentDTO dto){
		return  ResponseEntity.ok().body(new ResponseDTO("student saved", false,service.save(dto) ));
	}
	@GetMapping("/students")
	public ResponseEntity<ResponseDTO> get(){
		return ResponseEntity.ok().body(new ResponseDTO("employees", false,service.get() ));
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> update(@RequestBody StudentDTO dto) throws Exception{
		return ResponseEntity.ok(new ResponseDTO("update employees", false, service.update(dto)));
	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable Integer studentId){
		return ResponseEntity.ok(new ResponseDTO("deleted", false, service.delete(studentId)));
	}
	
	}
