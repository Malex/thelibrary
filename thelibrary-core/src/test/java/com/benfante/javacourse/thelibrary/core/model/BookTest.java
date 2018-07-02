package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBookConstruction() {
		long id = 1;
		String title = "A title";
		Author author = new Author(1, "The", "single author");
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		Book book = new Book(id, title, author, publisher, price);
		assertEquals(id, book.getId());
		assertEquals(title, book.getTitle());
		assertEquals(author, book.getAuthor()[0]);
		assertEquals(price, book.getPrice(), 0.1);
	}

	@Test
	public void testBookSetters() {
		long id = 1;
		String title = "A title";
		Author author = new Author(1, "The", "single author");
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		Book book = new Book(id, title, author, publisher, price);
		long newId = 2;
		String newTitle = "Another title";
		Author newAuthor = new Author(2, "Another", "author");
		Publisher newPublisher = new Publisher(2, "Another publisher");
		float newPrice = 2.34f;
		book.setId(newId);
		book.setTitle(newTitle);
		book.setAuthor(newAuthor);
		book.setPublisher(newPublisher);
		book.setPrice(newPrice);
		assertEquals(newId, book.getId());
		assertEquals(newTitle, book.getTitle());
		assertEquals(newAuthor, book.getAuthor()[1]);
		assertEquals(newPublisher, book.getPublisher());
		assertEquals(newPrice, book.getPrice(), 0.1);
	}

	@Test
	public void testIsAuthor() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		auth2.setLastName("Pluto");
		auth2.setId(3);
		Author[] arrAuth = {auth1,auth2};
		Book book = new Book(4,"ciao", arrAuth);
		assertTrue(book.isAuthor(auth1));
		assertTrue(book.isAuthor(auth2));
		assertTrue(book.isAuthor(new Author(1,"Pippo","Baudo")));
		assertFalse(book.isAuthor(new Author(10,"Carlo","Carlino")));
		
	}
	
	@Test
	public void testEquals() {
		long id = 1;
		String title = "A title";
		Author author = new Author(1, "The", "single author");
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		Book book = new Book(id, title, author, publisher, price);
		Book book2 = new Book(id, title, author, publisher, price);
		assertEquals(book,book2);
	}
	
}