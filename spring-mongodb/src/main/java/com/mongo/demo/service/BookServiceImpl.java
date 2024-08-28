package com.mongo.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongo.demo.dto.BookDTO;
import com.mongo.demo.entity.Book;
import com.mongo.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private BookRepository repository;

	@Override
	public BookDTO saveBook(BookDTO dto) {
		Book book = new Book();
		BeanUtils.copyProperties(dto, book);

		Book save = repository.save(book);
		BeanUtils.copyProperties(save, dto);
		return dto;

	}

	@Override
	public List<BookDTO> getBooks() {
		List<BookDTO> list = new ArrayList<>();

		List<Book> findAll = repository.findAll();
		findAll.stream().forEach(i -> {
			BookDTO dto = new BookDTO();
			BeanUtils.copyProperties(i, dto);
			list.add(dto);
		});

		return list;
	}

	@Override
	public BookDTO getBook(Integer id) {
		/*
		 * Optional<Book> findById = repository.findById(id);
		 * 
		 * if(findById.isPresent()) { Book book = findById.get(); BookDTO dto=new
		 * BookDTO(); BeanUtils.copyProperties(book, dto); return dto; } else { return
		 * null; }
		 */
		
		
//      Query query=new Query();
//		Query qId = query.addCriteria(Criteria.where("id").is(id));
//		Book book = mongoTemplate.findOne(qId, Book.class);
		
		Query query = new Query(Criteria.where("id").is(id));
		Book book = mongoTemplate.findOne(query, Book.class);
		BookDTO dto = new BookDTO();
		BeanUtils.copyProperties(book, dto);
		return dto;

	}

	@Override
	public BookDTO updateBook(BookDTO book) {
		Optional<Book> findById = repository.findById(book.getId());
		if (findById.isPresent()) {
			Book book2 = findById.get();
			BeanUtils.copyProperties(book, book2);
			Book save = repository.save(book2);
			BeanUtils.copyProperties(save, book);
			return book;
		}
		return null;

	}

	@Override
	public BookDTO deleteBook(Integer id) {

		Optional<Book> findById = repository.findById(id);
		if (findById.isPresent()) {
			repository.delete(findById.get());
		}
		return new BookDTO();
	}

	@Override
	public List<BookDTO> findName(String authorName) {

		Query query = new Query(Criteria.where("authorName").is(authorName));

		List<Book> list = mongoTemplate.find(query, Book.class);
		List<BookDTO> list1 = new ArrayList<>();
		list.stream().forEach(i -> {
			BookDTO dto = new BookDTO();
			BeanUtils.copyProperties(i, dto);
			list1.add(dto);
		});
		return list1;

		/*
		 * //this is for @Query return repository.findByName(authorName);
		 */
	}

	@Override
	public List<BookDTO> practice() {

		List<BookDTO> list = new ArrayList<>();
		
		// 1)-> using mongotemplate
		/*
		 * List<Book> findAll = mongoTemplate.findAll(Book.class);
		 * findAll.stream().forEach(i -> { BookDTO dto = new BookDTO();
		 * BeanUtils.copyProperties(i, dto); list.add(dto);});
		 */

		/*########################################### */
		
		
		Query query = new Query();
		
		/*
		 * //  2)->find names starting with F //
		 * query.addCriteria(Criteria.where("authorName").regex("^F"));
		 * 
		 * // find names ending with s
		 * query.addCriteria(Criteria.where("bookName").regex("s$"));
		 *List<Book> findAll = mongoTemplate.find(query, Book.class); 
		 *findAll.stream().forEach(i -> {
		 * BookDTO dto = new BookDTO();
		 *  BeanUtils.copyProperties(i, dto); 
		 *  list.add(dto);
		 * });
		 * 
		 */
		
		
		//3)-> lt->less than
//      query.addCriteria(Criteria.where("published").lt(2020));  
	    
		//gt->greater than
//		   query.addCriteria(Criteria.where("published").gt(2018));
		
//		query.addCriteria(Criteria.where("published").gte(2018)); //lte
		
		//4)-> for sorting
//		query.with(Sort.by(Sort.Direction.DESC, "published")); //ASC
		
		//5)->for pagination
		 Pageable page=PageRequest.of(0, 2);//page,size
		query.with(page);
		List<Book> find = mongoTemplate.find(query, Book.class);
		
		
    
		find.stream().forEach(i->{
			BookDTO dto=new BookDTO();
			BeanUtils.copyProperties(i, dto);
			list.add(dto);
		});
		return list;
	}

//	@Override
//	public BookDTO findABName(String authorName, String bookName) {
//       
//		 Book book = repository.findByAuthorNameAndBookName(authorName, bookName);
//	      System.err.println(book);
//		 BookDTO dto=new BookDTO();
//		 BeanUtils.copyProperties(book, dto);
//		 return dto;
//	}

}
