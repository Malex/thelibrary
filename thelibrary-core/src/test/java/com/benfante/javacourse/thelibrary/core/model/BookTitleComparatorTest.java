package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTitleComparatorTest {

	@Test
	public void testCompare() {
		Book book1 = new Book(2,"B book",new Author(1,"a","author"));
		Book book2 = new Book(2,"B book",new Author(1,"a","author"));
		Book book3 = new Book(1,"A book",new Author(1,"a","author"));
		Book book4 = new Book(4,"C book",new Author(1,"a","author"));
		assertTrue(book1.compareTo(book2)==0);
		assertTrue(book1.compareTo(book3)>0);
		assertTrue(book1.compareTo(book4)<0);
	}

}
