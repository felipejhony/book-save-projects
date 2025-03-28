package br.com.felipe.service;

import java.util.List;
import java.util.stream.IntStream;

import br.com.felipe.dao.BookDAO;
import br.com.felipe.dto.BookDTO;
import br.com.felipe.entity.Book;
import br.com.felipe.ui.UiConsole;

public class BookService {

	static BookDAO bookDAO = new BookDAO();
	
	public static void show() {
		
		List<Book> books = bookDAO.getBooks();
		if (books.isEmpty())
			System.out.println("A coleção de livros está vazia.");
		else
			IntStream.range(0, books.size())
					.forEach(i -> System.out.println("Índice: " + (i + 1) + ", Livro: " + books.get(i)));

	}

	public static void add() {

		System.out.println("Informe o título do livro:");
		String title = UiConsole.getString();
		System.out.println("Informe o autor do livro:");
		String author = UiConsole.getString();
		System.out.println("Informe o ano de publicação do livro:");
		int pubYear = UiConsole.getInt();

		Book newBook = new Book(title, author, pubYear);
		System.out.println("Livro adicionado!");
		
		bookDAO.addBook(newBook);
	}

	public static void update() {

		BookDTO bookDto = getBook();

		if (bookDto == null)
			return;

		System.out.println("Informe o título do livro ou vazio para manter " + bookDto.getBook().getTitle());

		String title = UiConsole.getString();
		if (title != null && !title.isEmpty())
			bookDto.getBook().setTitle(title);

		System.out.println("Informe o autor do livro ou vazio para manter " + bookDto.getBook().getAuthor());
		String author = UiConsole.getString();
		if (author != null && !author.isEmpty())
			bookDto.getBook().setAuthor(author);

		System.out.println("Informe o ano de publicação do livro ou 0 (ZERO) para manter " + bookDto.getBook().getPubYear());
		int pubYear = UiConsole.getInt();
		if (pubYear > 0)
			bookDto.getBook().setPubYear(pubYear);

		bookDAO.updateBook(bookDto.getIndex(), bookDto.getBook());
		System.out.println("Livro alterado!");
	}

	public static void delete() {

		BookDTO bookDto = getBook();

		if (bookDto.getIndex() == 0)
			return;

		bookDAO.deleteBook(bookDto.getIndex());

		System.out.println("Livro removido!");

	}

	private static BookDTO getBook() {
		int indice = 0;
		Book book = null;

		while (book == null) {
			
			System.out.println("Informe o índice do livro desejado ou 0 para cancelar:");
			
			indice = UiConsole.getInt();
			
			if (indice == 0)
				return null;
			
			try {
				List<Book> books = bookDAO.getBooks();
				
				book = books.get(indice - 1);
				System.out.println("Índice: " + (indice) + ", Livro: " + book.toString());
				
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Índice inválido!");
				System.out.println("==============================================================================");
			}
		}
		return new BookDTO(book, indice);
	}

}
