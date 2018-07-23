package com.benfante.javacourse.thelibrary.core.dao;

import java.util.Collection;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public interface BookDao {
	
	Collection<Book> findAll();
	
	Book findByIsbn(String isbn);
	
	Book[] findByTitle(String title);
	
	Book[] findByAuthor(Author author);
	
	Book store(Book book);
	
	void remove(Book book);
	
}
