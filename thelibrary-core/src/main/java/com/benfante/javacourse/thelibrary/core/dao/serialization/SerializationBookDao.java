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
	public Book findByIsbn(String isbn) {
		return this.serializationStorage.booksByIsbn.get(isbn);
	}

	@Override
	public Book[] findByTitle(String title) {
		return this.serializationStorage.booksByTitle.get(title).toArray(runtimeArr);
	}

	@Override
	public Book[] findByAuthor(Author author) {
		return this.serializationStorage.booksByAuthor.get(author).toArray(runtimeArr);
	}

	@Override
	public Book store(Book book) {
		this.serializationStorage.addBook(book);
		return book;
	}

	@Override
	public void remove(Book book) {
		this.serializationStorage.removeBook(book);		
	}

}
