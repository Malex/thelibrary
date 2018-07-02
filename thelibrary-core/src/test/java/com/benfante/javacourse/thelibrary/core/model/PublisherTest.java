package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PublisherTest {

	@Test
	public void equalsTest() {
		Publisher pub1 = new Publisher(1,"Mondadori");
		Publisher pub2 = new Publisher(1,"Mondadori");
		Publisher pub3 = new Publisher(2,"Hoepli");
		assertEquals(pub1,pub2);
		assertNotEquals(pub2, pub3);
	}
	
	@Test(expected = AssertionError.class)
	public void equalsAssertTest() {
		Publisher pub1 = new Publisher(1,"Mondadori");
		Publisher pub3 = new Publisher(1,"Hoepli");
		pub1.equals(pub3);
	}

}
