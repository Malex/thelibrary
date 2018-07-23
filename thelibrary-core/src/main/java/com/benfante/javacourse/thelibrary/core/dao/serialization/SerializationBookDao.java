package com.benfante.javacourse.thelibrary.core.dao.serialization;

import java.util.Collection;

import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;


public class SerializationBookDao implements BookDao {
	private static final Book[] runtimeArr = new Book[0]; 
	
	private SerializationStorage serializationStorage;
	
	
	public SerializationBookDao(SerializationStorage serializationStorage) {
		this.serializationStorage = serializationStorage;
	}

	@Override
	public Collection<Book> findAll() {
		return this.serializationStorage.books;
	}

	@Override
	public Book searchBookByIsbn(String isbn) {
		return this.serializationStorage.booksByIsbn.get(isbn);
	}

	@Override
	public Book[] searchBooksByTitle(String title) {
		return this.serializationStorage.booksByTitle.get(title).toArray(runtimeArr);
	}

	@Override
	public Book[] searchBooksByAuthor(Author author) {
		return this.serializationStorage.booksByAuthor.get(author).toArray(runtimeArr);
	}

	@Override
	public void store(Book book) {
		// TODO Auto-generated method stub
	}

}
