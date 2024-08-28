package com.techno.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	private String name;
	private Integer salary;
	private String designation;
}
