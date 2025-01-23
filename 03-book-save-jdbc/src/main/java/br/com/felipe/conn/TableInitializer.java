package br.com.felipe.conn;

import java.sql.Connection;
import java.sql.Statement;

public class TableInitializer {

	public static void createTable() {
		String dropTableSQL = "DROP TABLE IF EXISTS books";

		String createTableSQL = """
				CREATE TABLE IF NOT EXISTS books (
				    id INT AUTO_INCREMENT PRIMARY KEY,
				    title VARCHAR(255) NOT NULL,
				    author VARCHAR(255) NOT NULL,
				    pub_year INT
				);
				""";

		try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement()) {

			stmt.execute(dropTableSQL);
			stmt.execute(createTableSQL);

			System.out.println("Tabela 'books' criada ou já existe.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
