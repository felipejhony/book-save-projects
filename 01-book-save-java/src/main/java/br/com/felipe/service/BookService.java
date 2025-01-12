package br.com.felipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import br.com.felipe.entity.Book;
import br.com.felipe.ui.UiConsole;

public class BookService {

	// create list of Books
	private static List<Book> books = new ArrayList<>();

	public static void show() {

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
		books.add(newBook);
		System.out.println("Livro adicionado!");
	}

	public static void update() {

		Book book = getBook();

		if (book == null)
			return;

		System.out.println("Informe o título do livro ou vazio para manter " + book.getTitle());

		String title = UiConsole.getString();
		if (title != null && !title.isEmpty())
			book.setTitle(title);

		System.out.println("Informe o autor do livro ou vazio para manter " + book.getAuthor());
		String author = UiConsole.getString();
		if (author != null && !author.isEmpty())
			book.setAuthor(author);

		System.out.println("Informe o ano de publicação do livro ou 0 (ZERO) para manter " + book.getPubYear());
		int pubYear = UiConsole.getInt();
		if (pubYear > 0)
			book.setPubYear(pubYear);

		System.out.println("Livro alterado!");
	}

	public static void delete() {

		Book book = getBook();

		if (book == null)
			return;

		books.remove(book);

		System.out.println("Livro removido!");

	}

	private static Book getBook() {
		int indice = 0;
		Book book = null;

		while (book == null) {
			
			System.out.println("Informe o índice do livro para alterar ou 0 para cancelar:");
			
			indice = UiConsole.getInt();
			
			if (indice == 0)
				return null;
			
			try {
				
				book = books.get(indice - 1);
				System.out.println("Índice: " + (indice) + ", Livro: " + book.toString());
				
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Índice inválido!");
				System.out.println("==============================================================================");
			}
		}
		return book;
	}

}
