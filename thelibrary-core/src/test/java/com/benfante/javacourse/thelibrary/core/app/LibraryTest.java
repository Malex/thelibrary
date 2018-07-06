package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.model.*;

import static org.junit.Assert.*;

import java.io.*;
import java.math.BigDecimal;
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

	@Test
	public void testLoadBooks() {
		Library lib = new Library();
		try(InputStream in = this.getClass().getResourceAsStream("/books.txt")){
			Library arg = new Library();
			arg.addBook(new Book(1,"Dieci Piccoli Indiani",new Author(1,"Agatha","Christie"),new Publisher(1,"Mondadori"),new BigDecimal(10.5)));
			arg.addBook(new Book(2,"The Java Programming Language",new Author[] {new Author(2,"Ken","Arnolds"),new Author(3,"James","Gosling"),new Author(4,"David","Holmes")},new Publisher(2,"Addison-Wesley Professional"),new BigDecimal(10.5)));
			assertNotNull(in);
			lib.loadBooks(in,null);
			assertTrue(Arrays.equals(lib.getBooks(),arg.getBooks()));
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}
	
	@Test
	public void testSaveData() {
		Library lib = new Library();
		try(InputStream in = this.getClass().getResourceAsStream("/books.txt");){
			File f = new File(this.getClass().getResource("/books.dat").getFile());
			if(!f.exists())
				f.createNewFile();
			Library arg = new Library();
			arg.addBook(new Book(1,"Dieci Piccoli Indiani",new Author(1,"Agatha","Christie"),new Publisher(1,"Mondadori"),new BigDecimal(10.5)));
			arg.addBook(new Book(2,"The Java Programming Language",new Author[] {new Author(2,"Ken","Arnolds"),new Author(3,"James","Gosling"),new Author(4,"David","Holmes")},new Publisher(2,"Addison-Wesley Professional"),new BigDecimal(10.5)));
			assertNotNull(in);
			lib.loadBooks(in,null);
			lib.saveArchive();
			Library lib2 = Library.loadArchive();
			assertTrue(Arrays.equals(lib.getBooks(), lib2.getBooks()));
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			fail("It didnt work");
		}
	}
	
}
