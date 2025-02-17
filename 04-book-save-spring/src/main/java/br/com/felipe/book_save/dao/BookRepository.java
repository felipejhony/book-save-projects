package br.com.felipe.book_save.dao;

import br.com.felipe.book_save.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="books")
public interface BookRepository extends JpaRepository<Book, Integer> {
}
