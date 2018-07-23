package com.benfante.javacourse.thelibrary.core.dao;

import java.util.Collection;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public interface BookDao {
	
	public Collection<Book> getAllBooks();
	
	public Book searchBookByIsbn(String isbn);
	
	public Book[] searchBooksByTitle(String title);
	
	public Book[] searchBooksByAuthor(Author author);
	
	public void store(Book book);
	
}
