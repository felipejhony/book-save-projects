package br.com.felipe.booksave.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.booksave.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public List<Book> findAllByOrderByAuthorAsc();
}
