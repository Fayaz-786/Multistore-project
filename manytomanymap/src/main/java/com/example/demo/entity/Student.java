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
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
     @Id
 	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentId;
	private String name;
	private String branch;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Laptop> laptops;
	
}
