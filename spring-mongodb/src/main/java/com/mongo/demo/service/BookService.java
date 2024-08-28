package com.mongo.demo.service;

import java.util.List;

import com.mongo.demo.dto.BookDTO;

public interface BookService {

	public BookDTO saveBook(BookDTO book);

	public BookDTO getBook(Integer id);

	public List<BookDTO> getBooks();

	public BookDTO updateBook(BookDTO book);

	public BookDTO deleteBook(Integer id);

	public List<BookDTO>  findName(String authorName);

	public List<BookDTO> practice();

//	public BookDTO findABName(String authorName, String bookName);

}
