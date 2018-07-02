package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AuthorTest {

	
	@Test
	public void testAuthorEquals() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		assertEquals(auth1.equals(auth2),true);
		auth2.setId(3);
		assertEquals(auth1.equals(auth2),false);
		auth2.setId(1);
		auth2.setLastName("Pluto");
	}
	
	@Test(expected = AssertionError.class)
	public void testAuthorEqualsReally() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		auth2.setLastName("Pluto");
		assertEquals(auth1.equals(auth2),true);
	}
}
