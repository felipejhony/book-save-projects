package br.com.felipe;

import java.util.List;

import br.com.felipe.conn.TableInitializer;
import br.com.felipe.dao.BookDAO;
import br.com.felipe.entity.Book;
import br.com.felipe.service.BookService;

public class BookSave {

	public static void main(String[] args) {

		System.out.println("Bem Vindo!");
		System.out.println("TESTE...!");

		TableInitializer.createTable();
		BookDAO bookDAO = new BookDAO();
		Book newBook = new Book("1984", "George Orwell", 1949);
		bookDAO.saveBook(newBook);

		// Lista todos os livros do banco
		List<Book> books = bookDAO.getBooks();
		System.out.println("Livros cadastrados no banco:");
		for (Book book : books) {
			System.out.printf("ID: %d | Título: %s | Autor: %s | Ano: %d%n", book.getId(), book.getTitle(),
					book.getAuthor(), book.getPubYear());
		}

//		while (true) {
//			System.out.println("\n===============================================");
//			int opcao = -1;
//			while (opcao > 4 || opcao < 0) {
//				System.out.println("Digite o numero correpondente a opção desejada:");
//				System.out.println("1 - Ver livros cadastrados.");
//				System.out.println("2 - Cadastrar um livro novo.");
//				System.out.println("3 - Alterar um livro.");
//				System.out.println("4 - Deletar um livro cadastrado.");
//				System.out.println("0 - Sair.");
//
//				opcao = UiConsole.getInt();
//			}
//
//			processOption(opcao);
//		}

	}

	private static void processOption(int opcao) {

		switch (opcao) {

		case 1:
			System.out.println("Mostrando livros cadastrados...");
			BookService.show();
			break;

		case 2:
			System.out.println("Cadastrando novo livro...");
			BookService.add();
			break;

		case 3:
			System.out.println("Alterando um livro...");
			BookService.update();
			break;

		case 4:
			System.out.println("Deletando um livro...");
			BookService.delete();
			break;

		case 0:
			System.out.println("Saindo do programa...");
			System.exit(0);
			break;
		}

	}
}
