package br.com.felipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.felipe.conn.DatabaseConnection;
import br.com.felipe.entity.Book;

public class BookDAO {

	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		String selectSQL = "SELECT * FROM books";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Book book = new Book(rs.getString("title"), rs.getString("author"), rs.getInt("pub_year"));
				book.setId(rs.getInt("id"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void deleteBook(int index) {
		String insertSQL = "delete from books WHERE ID = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
			pstmt.setInt(1, index);
			pstmt.executeUpdate();
			System.out.println("Livro apagado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateBook(int index, Book book) {
		String insertSQL = "UPDATE books SET title = ? , author = ?, pub_year = ? WHERE ID = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPubYear());
			pstmt.setInt(4, index);
			pstmt.executeUpdate();
			System.out.println("Livro alterado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addBook(Book book) {
		String insertSQL = "INSERT INTO books (title, author, pub_year) VALUES (?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPubYear());
			pstmt.executeUpdate();
			System.out.println("Livro salvo com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
