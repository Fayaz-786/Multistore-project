package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lapId;
	private String brand;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy ="laptops")
	private List<Student> students;
	
}
