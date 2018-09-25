package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.model.utils.BookUtil;

public class AuthorTest {

//	Old test, before JPA changes	
//	@SuppressWarnings("unlikely-arg-type")
//	@Test
//	public void testAuthorEquals() {
//		Object auth1 = new Author(1,"Pippo","Baudo");
//		Author auth2 = new Author(1,"Pippo","Baudo");
//		assertTrue(auth1.equals(auth2));
//		auth2.setName(3);
//		assertFalse(auth1.equals(auth2));
//		assertFalse(auth1.equals(null));
//		auth2.setId(1);
//		assertFalse(auth2.equals(new String("ciao")));
//		
//	}
	
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
		
		Book book = BookUtil.generateBook(id, title, author, publisher, BigDecimal.valueOf(price));
		Book book3 = BookUtil.generateBook(id, title, auth1, publisher, BigDecimal.valueOf(price));

		Author auth2 = new Author(2,"Pippo","Baudo");
		auth2.setLastName("Pluto");
		auth2.setId(3);
		Author[] arrAuth = {auth1,auth2};
		Book book2 = BookUtil.generateBook(4,"ciao", arrAuth);
		
		assertFalse(auth1.isAuthor(book));
		assertTrue(auth1.isAuthor(book3));
		assertTrue(auth1.isAuthor(book2));
	}
	
	//Benfante tests
	@Test
	public void testEquals() {
		Author author1 = new Author(1, "AMB", "Let");
		Author author2 = new Author(1, "AMB", "Let");
		assertTrue(author1.equals(author2));
		author1 = new Author(1, "AMB", "Let");
		author2 = new Author(2, "AMB", "Let");
		assertTrue(author1.equals(author2));
	}

	@Test
	public void testEqualsFalse() {
		Author author1 = new Author(1, "AMB", "Let");
		Author author2 = new Author(1, "OMB", "Let");
		assertFalse(author1.equals(author2));
	}

	@Test
	public void testHashCode() {
		Author author1 = new Author(1, "", "");
		Author author2 = new Author(2, "", "");
		assertTrue(author1.hashCode() == author2.hashCode());
	}

	@Test
	public void testHashCodeDifferentMaybe() {
		Author author1 = new Author(1, "", "");
		Author author2 = new Author(2, "", "orpo");
		assertTrue(author1.hashCode() != author2.hashCode());
	}
}
