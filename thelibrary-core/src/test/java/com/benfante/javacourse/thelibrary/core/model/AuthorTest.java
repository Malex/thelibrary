package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class AuthorTest {

	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testAuthorEquals() {
		Object auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		assertTrue(auth1.equals(auth2));
		auth2.setId(3);
		assertFalse(auth1.equals(auth2));
		assertFalse(auth1.equals(null));
		auth2.setId(1);
		assertFalse(auth2.equals(new String("ciao")));
		
	}
	
//	@Test(expected = AssertionError.class)
//	public void testAuthorEqualsReally() {
//		Author auth1 = new Author(1,"Pippo","Baudo");
//		Author auth2 = new Author(1,"Pippo","Baudo");
//		auth2.setLastName("Pluto");
//		auth1.equals(auth2);
//	}
	
	@Test
	public void testIsAuthor() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author[] author = new Author[0];
		long id = 1;
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		String title = "A title";
		
		Book book = new Book(id, title, author, publisher, price);
		Book book3 = new Book(id, title, auth1, publisher, price);

		Author auth2 = new Author(2,"Pippo","Baudo");
		auth2.setLastName("Pluto");
		auth2.setId(3);
		Author[] arrAuth = {auth1,auth2};
		Book book2 = new Book(4,"ciao", arrAuth);
		
		assertFalse(auth1.isAuthor(book));
		assertTrue(auth1.isAuthor(book3));
		assertTrue(auth1.isAuthor(book2));
	}
}
