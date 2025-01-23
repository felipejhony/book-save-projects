package br.com.felipe.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	//Salvar em um arquivo no projeto
	private static final String URL = "jdbc:h2:./data/booksdb";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	static {
		//Carregar o driver
		try {
			Class.forName("org.h2.Driver"); 
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro ao carregar o driver H2", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
