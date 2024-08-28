package com.mongo.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	private Integer id;
	private String bookName;
	private String authorName;
	private Integer published;
}
