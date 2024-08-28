package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.StudentDTO;

public interface StudentService {

public StudentDTO save(StudentDTO dto);

public List<StudentDTO> get();

public StudentDTO update(StudentDTO dto) throws Exception;

public StudentDTO delete(Integer studentId);

}
