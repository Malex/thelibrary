package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	@Test
	public void testBookConstruction() {
		long id = 0;
		String title = "A title";
		Author author = new Author(1,"Agatha","Christie");
		float price = 1.23f;
		Book book = new Book(id, title, author, price);
		assertEquals(id, book.getId());
		assertEquals(title, book.getTitle());
		assertEquals(author, book.getAuthor()[0]);
		assertEquals(price, book.getPrice(), 0.1);
	}

	@Test
	public void testBookSetters() {
		long id = 0;
		String title = "A title";
		Author author = new Author(1,"Agatha","Christie");
		float price = 1.23f;
		Book book = new Book(id, title, author, price);
		long newId = 0;
		String newTitle = "A special title";
		Author newAuthor = new Author(4,"Geroge","Martin");
		float newPrice = 1.23f;
		book.setId(newId);
		book.setTitle(newTitle);
		book.setAuthor(newAuthor);
		book.setPrice(newPrice);
		assertEquals(newId, book.getId());
		assertEquals(newTitle, book.getTitle());
		assertEquals(newAuthor, book.getAuthor()[1]);
		assertEquals(newPrice, book.getPrice(), 0.1);
	}
	
}
