package br.com.felipe.booksave.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.felipe.booksave.domain.Book;
import br.com.felipe.booksave.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/list")
	public String listBooks(Model model) {
		
		List<Book> list = bookService.findAll();
		
		model.addAttribute("books", list);
		
		return "list-books";
	}
	
	
}
