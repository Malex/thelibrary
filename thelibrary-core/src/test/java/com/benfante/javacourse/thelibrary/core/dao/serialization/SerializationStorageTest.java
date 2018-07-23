package com.benfante.javacourse.thelibrary.core.dao.serialization;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class SerializationStorageTest {

	@Test
	public void testAddBook() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		SerializationStorage lib = new SerializationStorage();
		lib.addBook(b.get(0));
		Collection<Book> set = new HashSet<>(b);
		assertTrue(set.equals(lib.books));
	}
	
	@Test
	public void testAddBooks() {
		Collection<Book> b = new HashSet<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		SerializationStorage lib = new SerializationStorage();
		lib.addBooks(b);
		assertTrue(b.equals(lib.books));
	}
	
	@Test
	public void testRemoveBook() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		SerializationStorage lib = new SerializationStorage();
		lib.addBooks(b);
		lib.removeBook(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		Collection<Book> b2 = new HashSet<>();
		b2.add(b.get(0));
		b2.add(b.get(2));
		assertTrue(b2.equals(lib.books));
	}

	@Test
	public void testRemoveBooks() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(3,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		SerializationStorage lib = new SerializationStorage();
		lib.addBooks(b);
		List<Book> b3 = new LinkedList<>();
		b3.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b3.add(new Book(3,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		lib.removeBooks(b3);
		Collection<Book> b2 = new HashSet<>();
		b2.add(b.get(0));
		assertTrue(b2.equals(lib.books));
		
	}
	
	

}