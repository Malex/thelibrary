package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookIsbnComparatorTest {

	@Test
	public void testCompare() {
		Book book1 = new Book(1,"A book",new Author(1,"a","author"));
		Book book2 = new Book(1,"A book",new Author(1,"a","author"));
		Book book3 = new Book(1,"A book",new Author(1,"a","author"));
		Book book4 = new Book(1,"A book",new Author(1,"a","author"));
		book1.setIsbn("12345");
		book2.setIsbn("12345");
		book3.setIsbn("02159");
		book4.setIsbn("552369");
		BookIsbnComparator com = new BookIsbnComparator();
		assertTrue(com.compare(book1, book2)==0);
		assertTrue(com.compare(book1, book4)<0);
		assertTrue(com.compare(book1, book3)>0);
	}

}
