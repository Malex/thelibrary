package com.benfante.javacourse.thelibrary.core.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBookConstruction() {
		long id = 1;
		String title = "A title";
		Author author = new Author(1, "The", "single author");
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		Book book = new Book(id, title, author, publisher, BigDecimal.valueOf(price));
		assertEquals(id, book.getId());
		assertEquals(title, book.getTitle());
		assertEquals(author, book.getAuthor().get(0));
		assertEquals(book.getPrice().compareTo(BigDecimal.valueOf(price)), 0);
	}

	@Test
	public void testBookSetters() {
		long id = 1;
		String title = "A title";
		Author author = new Author(1, "The", "single author");
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		Book book = new Book(id, title, author, publisher, BigDecimal.valueOf(price));
		long newId = 2;
		String newTitle = "Another title";
		Author newAuthor = new Author(2, "Another", "author");
		Publisher newPublisher = new Publisher(2, "Another publisher");
		float newPrice = 2.34f;
		book.setId(newId);
		book.setTitle(newTitle);
		book.setAuthor(newAuthor);
		book.setPublisher(newPublisher);
		book.setPrice(newPrice);
		assertEquals(newId, book.getId());
		assertEquals(newTitle, book.getTitle());
		assertEquals(newAuthor, book.getAuthor().get(0));
		assertEquals(newPublisher, book.getPublisher());
		assertEquals(book.getPrice().compareTo(BigDecimal.valueOf(newPrice)), 0);
	}

	@Test
	public void testHasAuthor() {
		Author auth1 = new Author(1,"Pippo","Baudo");
		Author auth2 = new Author(1,"Pippo","Baudo");
		auth2.setLastName("Pluto");
		auth2.setId(3);
		Author[] arrAuth = {auth1,auth2};
		Book book = new Book(4,"ciao", arrAuth);
		assertTrue(book.hasAuthor(auth1));
		assertTrue(book.hasAuthor(auth2));
		assertTrue(book.hasAuthor(new Author(1,"Pippo","Baudo")));
		assertFalse(book.hasAuthor(new Author(10,"Carlo","Carlino")));
		
	}
	
	
	@Test 
	public void testNoAuthor() {
		Author[] author = new Author[0];
		long id = 1;
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		String title = "A title";
		
		Book book = new Book(id, title, author, publisher, BigDecimal.valueOf(price));
		Author auth2 = new Author(1,"Pippo","Baudo");
		assertFalse(book.hasAuthor(auth2));
		//System.out.println(book.getPrint());
		Book book2 = new Book(id, title, author, publisher, BigDecimal.valueOf(price));
		assertEquals(book,book2);
		
	}
	
	
	@Test
	public void testEquals() {
		long id = 1;
		String title = "A title";
		Author author = new Author(1, "The", "single author");
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		Book book = new Book(id, title, author, publisher, BigDecimal.valueOf(price));
		Book book2 = new Book(id, title, author, publisher, BigDecimal.valueOf(price));
		assertEquals(book,book2);
		assertEquals(book.hashCode(),book2.hashCode());
		book2.setId(3);
		assertNotEquals(book.hashCode(),book2.hashCode());
	}
	
	@Test
	public void testCategory() {
		long id = 1;
		String title = "A title";
		Author author = new Author(1, "The", "single author");
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		Book book = new Book(id, title, author, publisher, BigDecimal.valueOf(price));
		book.addCategory(BookCategory.ARTS_AND_PHOTOGRAPHY);
		SortedSet<BookCategory> tmp= new TreeSet<>();
		tmp.add(BookCategory.ARTS_AND_PHOTOGRAPHY);
		assertTrue(book.getCategories().equals(tmp));
		SortedSet<BookCategory> cat = new TreeSet<>(); 
		cat.add(BookCategory.HISTORY);cat.add(BookCategory.LITERATURE_AND_FICTION);cat.add(BookCategory.OTHER);
		book.setCategories(cat);
		SortedSet<BookCategory> new_cat = new TreeSet<>();
		new_cat.add(BookCategory.HISTORY);new_cat.add(BookCategory.LITERATURE_AND_FICTION);new_cat.add(BookCategory.OTHER);
		assertTrue(book.getCategories().equals(new_cat));
		//Following test was not to generate dupes, no longer needed
//		SortedSet<BookCategory> new_cat_dup = new TreeSet<>(); 
//		new_cat_dup.add(BookCategory.HISTORY);new_cat_dup.add(BookCategory.LITERATURE_AND_FICTION);new_cat_dup.add(BookCategory.OTHER);
//		book.addCategory(BookCategory.OTHER);
//		assertFalse(book.getCategories().equals(new_cat_dup));
	}
	
	
	@Test
	public void testCompare() {
		Book book1 = new Book(2,"A book",new Author(1,"a","author"));
		Book book2 = new Book(2,"A book",new Author(1,"a","author"));
		Book book3 = new Book(1,"A book",new Author(1,"a","author"));
		Book book4 = new Book(4,"A book",new Author(1,"a","author"));
		assertTrue(book1.compareTo(book2)==0);
		assertTrue(book1.compareTo(book3)>0);
		assertTrue(book1.compareTo(book4)<0);
	}
	
}