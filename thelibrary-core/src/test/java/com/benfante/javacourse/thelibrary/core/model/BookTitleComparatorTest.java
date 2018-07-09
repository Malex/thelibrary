package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTitleComparatorTest {

	@Test
	public void testCompare() {
		BookTitleComparator com = BookTitleComparator.getInstance();
		
		Book book1 = new Book(2,"B book",new Author(1,"a","author"));
		Book book2 = new Book(2,"B book",new Author(1,"a","author"));
		Book book3 = new Book(1,"A book",new Author(1,"a","author"));
		Book book4 = new Book(4,"C book",new Author(1,"a","author"));
		assertTrue(com.compare(book1, book2)==0);
		assertTrue(com.compare(book1, book3)>0);
		assertTrue(com.compare(book1, book4)<0);
	}

}
