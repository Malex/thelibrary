package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthorTest {

	
	@Test
	public void testAuthorEquals() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		assertTrue(auth1.equals(auth2));
		auth2.setId(3);
		assertFalse(auth1.equals(auth2));
		auth2.setId(1);
		auth2.setLastName("Pluto");
	}
	
	@Test(expected = AssertionError.class)
	public void testAuthorEqualsReally() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		auth2.setLastName("Pluto");
		assertTrue(auth1.equals(auth2));
	}
}
