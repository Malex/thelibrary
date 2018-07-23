package com.benfante.javacourse.thelibrary.core.dao.serialization;

import java.util.Collection;


import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class SerializationBookDao implements BookDao {
	private static final Book[] runtimeArr = new Book[0]; 
	
	@Override
	public Collection<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] searchBooksByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] searchBooksByAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Book book) {
		// TODO Auto-generated method stub

	}

}
