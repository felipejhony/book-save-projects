package br.com.felipe.booksave.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

		return "books/list-books";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Book book = new Book();

		model.addAttribute("book", book);

		return "books/book-form";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.save(book);
		
		return "redirect:/books/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int id, Model model) {
		Book book = bookService.findById(id);

		model.addAttribute("book", book);

		return "books/book-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bookId") int id) {
		
		bookService.deleteById(id);
		
		return "redirect:/books/list";
	}

}
