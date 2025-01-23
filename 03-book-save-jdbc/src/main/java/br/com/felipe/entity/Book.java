package br.com.felipe.entity;

import java.io.Serializable;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String author;
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
		return "Título: " + title + ", Autor: " + author + ", Ano de Publicação: " + pubYear + "";
	}
}
