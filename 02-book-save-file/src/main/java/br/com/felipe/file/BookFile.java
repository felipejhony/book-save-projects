package br.com.felipe.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.felipe.entity.Book;

public class BookFile {

	private static final String FILE_PATH = "books.dat";

	public static List<Book> getBooks() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
			List<Book> ret = (List<Book>) ois.readObject();
			ois.close();
			return ret;
		} catch (FileNotFoundException e) {
			return new ArrayList<>();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void addBook(Book newBook) {
		List<Book> books = getBooks();
		books.add(newBook);
		saveBooks(books);
	}

	public static void updateBook(int index, Book updatedBook) {

		List<Book> books = getBooks();

		if (index >= 0 && index < books.size()) {
			books.set(index, updatedBook);
			saveBooks(books);
		} else {
			System.out.println("Índice inválido.");
		}
	}

	public static void deleteBook(int index) {
		List<Book> books = getBooks();
		if (index >= 0 && index < books.size()) {
			books.remove(index);
			saveBooks(books);
		} else {
			System.out.println("Índice inválido.");
		}
	}

	private static void saveBooks(List<Book> books) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(books);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
