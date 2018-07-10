package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.model.*;

import static org.junit.Assert.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void testAddBook() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		Library lib = new Library();
		lib.addBook(b.get(0));
		assertTrue(b.equals(lib.getBooks()));
	}
	
	@Test
	public void testAddBooks() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		Library lib = new Library();
		lib.addBooks(b);
		assertTrue(b.equals(lib.getBooks()));
	}

	@Test
	public void testRemoveBook() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		Library lib = new Library();
		lib.addBooks(b);
		lib.removeBook(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		List<Book> b2 = new LinkedList<>();
		b2.add(b.get(0));
		b2.add(b.get(2));
		assertTrue(b2.equals(lib.getBooks()));
	}

	@Test
	public void testRemoveBooks() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(3,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		Library lib = new Library();
		lib.addBooks(b);
		List<Book> b3 = new LinkedList<>();
		b3.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b3.add(new Book(3,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		lib.removeBooks(b3);
		Collection<Book> b2 = new LinkedList<>();
		b2.add(b.get(0));
		assertTrue(b2.equals(lib.getBooks()));
		
	}

	//method no longer exists. test is wrong for old method now
//	@Test
//	public void testTrimBooks() {
//		List<Book> b = new LinkedList<>();
//		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
//		b.add(null);
//		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
//		Library lib = new Library();
//		lib.addBooks(b);
//		lib.trimBooks();
//		b = new Book[3];
//		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
//		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
//		b[2]=new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow"));
//		assertTrue(Arrays.equals(b, lib.getBooks()));

//	}

	@Test
	public void testSearchBooksByTitle() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(5,"Sanremo",new Author(5,"Pippow","Baudow")));
		Library lib = new Library();
		lib.addBooks(b);
		Collection<Book> ret=lib.searchBooksByTitle("Sanremo");
		Collection<Book> b2 = new LinkedList<>() ;
		b2.add(b.get(0));
		b2.add(b.get(2));
		assertTrue(ret.equals(b2));
	}

	@Test
	public void testSearchBooksByAuthor() {
		List<Book> b = new LinkedList<>();
		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
		Author Pippo = new Author(3, "Pippo", "Baudo");
		Library lib = new Library();
		lib.addBooks(b);
		Collection<Book> ret=lib.searchBooksByAuthor(Pippo);
		Collection<Book> b2 = new LinkedList<>() ;
		b2.add(b.get(0));
		b2.add(b.get(1));
		assertTrue(ret.equals(b2));
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
			assertTrue(lib.getBooks().equals(arg.getBooks()));
		} catch (IOException | RuntimeException e) {
			System.out.println("File not found");
			fail("prova");
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
			assertTrue(lib.getBooks().equals(lib2.getBooks()));
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
			fail("It didnt work");
		}
		
	}
	
	
}
