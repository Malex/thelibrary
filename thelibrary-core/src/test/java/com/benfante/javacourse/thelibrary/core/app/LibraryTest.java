package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.model.*;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void testAddBook() {
		Book[] b = new Book[1];
		b[0] = new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
		Library lib = new Library();
		lib.addBook(b[0]);
		assertTrue(Arrays.equals(lib.getBooks(),b));
	}
	
	@Test
	public void testAddBooks() {
		Book[] b = new Book[3];
		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
		b[2]=new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow"));
		Library lib = new Library();
		lib.addBooks(b);
		assertTrue(Arrays.equals(b, lib.getBooks()));
	}

	@Test
	public void testRemoveBook() {
		Book[] b = new Book[3];
		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
		b[2]=new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow"));
		Library lib = new Library();
		lib.addBooks(b);
		lib.removeBook(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		Book[] b2 = new Book[2];
		b2[0]=b[0];
		b2[1]=b[2];
		assertTrue(Arrays.equals(b2, lib.getBooks()));
	}

	@Test
	public void testRemoveBooks() {
		Book[] b = new Book[3];
		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
		b[2]=new Book(3,"Sanremeeeo",new Author(5,"Pippow","Baudow"));
		Library lib = new Library();
		lib.addBooks(b);
		Book[] b3 = new Book[2];
		b3[0]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
		b3[1]=new Book(3,"Sanremeeeo",new Author(5,"Pippow","Baudow"));
		lib.removeBooks(b3);
		Book[] b2 = new Book[1];
		b2[0]=b[0];
		assertTrue(Arrays.equals(b2, lib.getBooks()));
		
	}

	@Test
	public void testTrimBooks() {
		Book[] b = new Book[4];
		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
		b[2]=null;
		b[3]=new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow"));
		Library lib = new Library();
		lib.addBooks(b);
		lib.trimBooks();
		b = new Book[3];
		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
		b[2]=new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow"));
		assertTrue(Arrays.equals(b, lib.getBooks()));

	}

	@Test
	public void testSearchBooksByTitle() {
		Book[] b = new Book[3];
		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
		b[2]=new Book(5,"Sanremo",new Author(5,"Pippow","Baudow"));
		Library lib = new Library();
		lib.addBooks(b);
		Book[] ret=lib.searchBooksByTitle("Sanremo");
		Book[] b2 = new Book[] {b[0],b[2]};
		assertTrue(Arrays.equals(ret, b2));
	}

	@Test
	public void testSearchBooksByAuthor() {
		Book[] b = new Book[3];
		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
		b[2]=new Book(5,"Sanremo",new Author(5,"Pippow","Baudow"));
		Author Pippo = new Author(3, "Pippo", "Baudo");
		Library lib = new Library();
		lib.addBooks(b);
		Book[] ret=lib.searchBooksByAuthor(Pippo);
		Book[] b2 = new Book[] {b[0],b[1]};
		assertTrue(Arrays.equals(ret, b2));
	}

}
