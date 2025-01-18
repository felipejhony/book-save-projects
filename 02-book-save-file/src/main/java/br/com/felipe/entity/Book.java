package br.com.felipe.entity;

public class Book {
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

	@Override
	public String toString() {
		return "Título: " + title + ", Autor: " + author + ", Ano de Publicação: " + pubYear + "";
	}
}
