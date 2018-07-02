package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Before;
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
	public void testBookEquals() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		assertEquals(auth1.equals(auth2),true);
		auth2.setId(3);
		assertEquals(auth1.equals(auth2),false);
		auth2.setId(1);
		auth2.setLastName("Pluto");
	}
	
	@Test(expected = AssertionError.class)
	public void testBookEqualsReally() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		auth2.setLastName("Pluto");
		assertEquals(auth1.equals(auth2),true);
	}
	
}