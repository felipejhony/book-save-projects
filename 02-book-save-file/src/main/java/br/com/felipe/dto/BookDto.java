package br.com.felipe.dto;

import br.com.felipe.entity.Book;

public class BookDto {
	private Book book;
	private int index;
	
	public BookDto(Book book, int index) {
		this.book = book;
		this.index = index;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
