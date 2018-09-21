package com.benfante.javacourse.thelibrary.core.model.comparator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

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
		BookIsbnComparator com = BookIsbnComparator.getInstance();
		assertTrue(com.compare(book1, book2)==0);
		assertTrue(com.compare(book1, book4)<0);
		assertTrue(com.compare(book1, book3)>0);
	}

	@Test
	public void sortCompare() {
		BookIsbnComparator com = BookIsbnComparator.getInstance();
		
		Book book1 = new Book(1,"A book",new Author(1,"a","author"));
		Book book2 = new Book(1,"A book",new Author(1,"a","author"));
		Book book3 = new Book(1,"A book",new Author(1,"a","author"));
		Book book4 = new Book(1,"A book",new Author(1,"a","author"));
		book1.setIsbn("12345");
		book2.setIsbn("12345");
		book3.setIsbn("02159");
		book4.setIsbn("552369");
		
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
	
	
	@Test
	public void sortCompareReverse() {
		BookIsbnComparator com = BookIsbnComparator.getInstance();
		
		Book book1 = new Book(1,"A book",new Author(1,"a","author"));
		Book book2 = new Book(1,"A book",new Author(1,"a","author"));
		Book book3 = new Book(1,"A book",new Author(1,"a","author"));
		Book book4 = new Book(1,"A book",new Author(1,"a","author"));
		book1.setIsbn("12345");
		book2.setIsbn("12345");
		book3.setIsbn("02159");
		book4.setIsbn("552369");
		
		List<Book> tmp = new LinkedList<>();
		tmp.add(book4);
		tmp.add(book3);
		tmp.add(book2);
		tmp.add(book1);
		
		List<Book> ordered = new LinkedList<>();
		ordered.add(book4);
		ordered.add(book1);
		ordered.add(book2);
		ordered.add(book3);
	
		tmp.sort(com.reversed());
		
		assertEquals(tmp,ordered);
	}
	
}
