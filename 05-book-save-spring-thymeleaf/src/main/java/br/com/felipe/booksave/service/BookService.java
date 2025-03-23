package br.com.felipe.booksave.service;

import java.util.List;

import br.com.felipe.booksave.domain.Book;

public interface BookService {
	
	List<Book> findAll();
	
	Book findById(int id);
	
	Book save(Book book);
	
	void deleteById(int id);

}
