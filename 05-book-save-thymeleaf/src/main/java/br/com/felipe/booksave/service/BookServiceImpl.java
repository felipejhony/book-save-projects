package br.com.felipe.booksave.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.felipe.booksave.domain.Book;
import br.com.felipe.booksave.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> findAll() {

		return bookRepository.findAll();
	}

	@Override
	public Book findById(int id) {
		Optional<Book> result = bookRepository.findById(id);
		
		Book book = null;
		
		if(result.isPresent()) 
			book = result.get();
		else
			throw new RuntimeException("Nao achamos o livro id - " + id);
		
		return book;
	}

	@Override
	public Book save(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
	
	
	
	
}
