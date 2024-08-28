package com.mongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongo.demo.entity.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

//	@Query("{'authorName':?0}")
//	List<BookDTO> findByName(String authorName);
	
	
//	@Query("{'authorName':?0,'bookName':?1}") //0 means first parameter,1 means second parameter
//	Book findByAuthorNameAndBookName(String authorName,String bookName);
}
