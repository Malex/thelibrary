package com.benfante.javacourse.thelibrary.core.dao.serialization;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class SerializationBookDaoTest {

	@Test
	public void testFindByIsbn() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindByAuthorAfterRemove() throws ClassNotFoundException, IOException {
		SerializationBookDao instance = null;
		try (InputStream is = this.getClass().getResourceAsStream("/archive.dat");) {
			instance = new SerializationBookDao(new SerializationStorage(is));
			assertNotNull(instance);
			assertNotNull(instance.findAll());
			assertFalse(instance.findAll().isEmpty());
			
			Author author = new Author(1, "Agatha", "Christie");
			Book[] searchResult = instance.findByAuthor(author);
			assertEquals(1, searchResult.length);
			
			instance.store(new Book(5,"Orient Express", author));
			searchResult = instance.findByAuthor(author);
			assertEquals(2, searchResult.length);
			
			instance.remove(searchResult[0]);
			searchResult = instance.findByAuthor(author);
			assertEquals(1, searchResult.length);
		}
	}
	
	@Test
	public void testFindByAuthor() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		Author Pippo = new Author(3, "Pippo", "Baudo");
		SerializationBookDao lib = new SerializationBookDao(new SerializationStorage());
		lib.serializationStorage.addBooks(b);
		Book[] ret=lib.findByAuthor(Pippo);
		Book[] b2 = new Book[2] ;
		b2[0]=b.get(0);
		b2[1]=b.get(1);
		assertTrue(Arrays.equals(ret, b2));	
	}

	@Test
	public void testFindByTitle() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(5,"Sanremo",new Author(5,"Pippow","Baudow")));
		SerializationBookDao lib = new SerializationBookDao(new SerializationStorage());
		lib.serializationStorage.addBooks(b);
		Book[] ret=lib.findByTitle("Sanremo");
		Book[] b2 = new Book[2] ;
		b2[0]=b.get(0);
		b2[1]=b.get(2);
		assertTrue(Arrays.equals(ret, b2));
	}

	@Test
	public void testFindByTitleAfterRemove() throws ClassNotFoundException, IOException {
		SerializationBookDao app = null;
		try (InputStream is = this.getClass().getResourceAsStream("/archive.dat");) {
			//System.out.println(this.getClass().getResource("/archive.dat"));
			app = new SerializationBookDao(new SerializationStorage(is));
		}
		String title = "Dieci Piccoli Indiani";
		Book[] searchResult = app.findByTitle(title);
		app.remove(searchResult[0]);
		searchResult = app.findByTitle(title);
		assertEquals(0, searchResult.length);
	}
	
}
