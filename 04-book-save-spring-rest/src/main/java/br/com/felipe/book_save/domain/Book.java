package br.com.felipe.book_save.domain;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "book")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;
	@Column(name = "pub_year")
	private int pubYear;

	public Book() {
		super();
	}

	public Book(String title, String author, int pubYear) {
		this.title = title;
		this.author = author;
		this.pubYear = pubYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id: " + id + ", Titulo: " + title + ", Autor: " + author + ", Ano de Pub: " + pubYear;
	}
	
}
