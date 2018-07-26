package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

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

	@Test
	public void sortCompare() {
		BookTitleComparator com = BookTitleComparator.getInstance();
		
		Book book1 = new Book("1","B book",new Author(1,"a","author"));
		Book book2 = new Book("2","B book",new Author(1,"a","author"));
		Book book3 = new Book("1","A book",new Author(1,"a","author"));
		Book book4 = new Book("4","C book",new Author(1,"a","author"));
		
		List<Book> tmp = new LinkedList<>();
		tmp.add(book4);
		tmp.add(book3);
		tmp.add(book2);
		tmp.add(book1);
		
		List<Book> ordered = new LinkedList<>();
		ordered.add(book3);
		ordered.add(book2);
		ordered.add(book1);
		ordered.add(book4);
		
		
		tmp.sort(com);
		
		assertEquals(tmp,ordered);
	}
}
