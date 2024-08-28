package com.mongo.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.demo.dto.BookDTO;
import com.mongo.demo.dto.ResponseDTO;
import com.mongo.demo.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController {

//	@Autowired
	
	@lombok.NonNull
	private  BookService service;
	
	@PostMapping("/book")
	public ResponseEntity<ResponseDTO> saveBook(@RequestBody BookDTO dto) {
		
		return ResponseEntity.ok().body(new ResponseDTO(false,"saved successfully",service.saveBook(dto)));
	
	}
	
	@GetMapping("/books")
	public ResponseEntity<ResponseDTO> getBooks(){
		return ResponseEntity.ok(new ResponseDTO(false,"books got successfully",service.getBooks()));
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<ResponseDTO> getBook(@PathVariable Integer id){
		return ResponseEntity.ok(new ResponseDTO(false,"book got successfully",service.getBook(id)));
	}
	
	@PutMapping("/bookUpdate")
	public ResponseEntity<ResponseDTO> updateBook(@RequestBody BookDTO dto){
		return ResponseEntity.ok(new ResponseDTO(false,"book updated successfully",service.updateBook(dto)));
	}
	
	
	@DeleteMapping("/bookdelete/{id}")
	public ResponseEntity<ResponseDTO> deleteBook(@PathVariable Integer id){
		return ResponseEntity.ok(new ResponseDTO(false,"book updated successfully",service.deleteBook(id)));
	}
	
	@GetMapping("/find/{authorName}")
	public ResponseEntity<ResponseDTO> findName(@PathVariable String authorName){
		return ResponseEntity.ok(new ResponseDTO(false, "got name successfully", service.findName(authorName)));
		
	}
	
	@GetMapping("/practice")
	public ResponseEntity<ResponseDTO> practice(){
		return ResponseEntity.ok(new ResponseDTO(false,"books got successfully",service.practice()));
	}
	
//	@GetMapping("/books/{authorName}/{bookName}")
//	public ResponseEntity<ResponseDTO> findABName(@PathVariable String authorName,@PathVariable String bookName){
//		return ResponseEntity.ok(new ResponseDTO(false, "got name successfully", service.findABName(authorName,bookName)));
//	}6
	
}
	

