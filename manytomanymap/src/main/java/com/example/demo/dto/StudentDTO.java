package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    
	private Integer studentId;
	private String name;
	private String branch;
	
	private List<LaptopDTO> laptop;
}
