package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.model.*;

import static org.junit.Assert.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LibraryTest {
//	private OutputStream nullPrintStream =
//			new OutputStream() {
//				@Override
//				public void write(int b) throws IOException {
//				}
//			};
//	
//	
//	@Test
//	public void testAddBook() {
//		List<Book> b = new LinkedList<>();
//		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
//		Library lib = new Library();
//		lib.addBook(b.get(0));
//		Collection<Book> set = new HashSet<>(b);
//		assertTrue(set.equals(lib.getBooks()));
//	}
//	
//	@Test
//	public void testAddBooks() {
//		Collection<Book> b = new HashSet<>();
//		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
//		Library lib = new Library();
//		lib.addBooks(b);
//		assertTrue(b.equals(lib.getBooks()));
//	}
//
//	@Test
//	public void testRemoveBook() {
//		List<Book> b = new LinkedList<>();
//		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
//		Library lib = new Library();
//		lib.addBooks(b);
//		lib.removeBook(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
//		Collection<Book> b2 = new HashSet<>();
//		b2.add(b.get(0));
//		b2.add(b.get(2));
//		assertTrue(b2.equals(lib.getBooks()));
//	}
//
//	@Test
//	public void testRemoveBooks() {
//		List<Book> b = new LinkedList<>();
//		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(3,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
//		Library lib = new Library();
//		lib.addBooks(b);
//		List<Book> b3 = new LinkedList<>();
//		b3.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
//		b3.add(new Book(3,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
//		lib.removeBooks(b3);
//		Collection<Book> b2 = new HashSet<>();
//		b2.add(b.get(0));
//		assertTrue(b2.equals(lib.getBooks()));
//		
//	}
//
//	//method no longer exists. test is wrong for old method now
////	@Test
////	public void testTrimBooks() {
////		List<Book> b = new LinkedList<>();
////		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
////		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
////		b.add(null);
////		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
////		Library lib = new Library();
////		lib.addBooks(b);
////		lib.trimBooks();
////		b = new Book[3];
////		b[0]=new Book(1,"Sanremo",new Author(3,"Pippo","Baudo"));
////		b[1]=new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo"));
////		b[2]=new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow"));
////		assertTrue(Arrays.equals(b, lib.getBooks()));
//
////	}
//
//	@Test
//	public void testSearchBooksByTitle() {
//		List<Book> b = new LinkedList<>();
//		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(5,"Sanremo",new Author(5,"Pippow","Baudow")));
//		Library lib = new Library();
//		lib.addBooks(b);
//		Book[] ret=lib.searchBooksByTitle("Sanremo");
//		Book[] b2 = new Book[2] ;
//		b2[0]=b.get(0);
//		b2[1]=b.get(2);
//		assertTrue(Arrays.equals(ret, b2));
//	}
//
//	@Test
//	public void testSearchBooksByAuthor() {
//		List<Book> b = new LinkedList<>();
//		b.add(new Book(1,"Sanremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(4,"Sawnremo",new Author(3,"Pippo","Baudo")));
//		b.add(new Book(5,"Sanremeeeo",new Author(5,"Pippow","Baudow")));
//		Author Pippo = new Author(3, "Pippo", "Baudo");
//		Library lib = new Library();
//		lib.addBooks(b);
//		Book[] ret=lib.searchBooksByAuthor(Pippo);
//		Book[] b2 = new Book[2] ;
//		b2[0]=b.get(0);
//		b2[1]=b.get(1);
//		assertTrue(Arrays.equals(ret, b2));
//	}
//
//	@Test
//	public void testLoadBooks() {
//		Library lib = new Library();
//		try(InputStream in = this.getClass().getResourceAsStream("/books.txt")){
//			Library arg = new Library();
//			arg.addBook(new Book(1,"Dieci Piccoli Indiani",new Author(1,"Agatha","Christie"),new Publisher(1,"Mondadori"),new BigDecimal(10.5)));
//			arg.addBook(new Book(2,"The Java Programming Language",new Author[] {new Author(2,"Ken","Arnolds"),new Author(3,"James","Gosling"),new Author(4,"David","Holmes")},new Publisher(2,"Addison-Wesley Professional"),new BigDecimal(10.5)));
//			assertNotNull(in);
//			lib.loadBooks(in,null);
//			assertTrue(lib.getBooks().equals(arg.getBooks()));
//		} catch (IOException | RuntimeException e) {
//			System.out.println("File not found");
//			fail("prova");
//		}
//	}
//	
//	@Test
//	public void testSaveData() {
//		Library lib = new Library();
//		try(InputStream in = this.getClass().getResourceAsStream("/books.txt");){
////			File f = new File(this.getClass().getResource("/books.dat").getFile());
////			if(!f.exists())
////				f.createNewFile();
//			Library arg = new Library();
//			arg.addBook(new Book(1,"Dieci Piccoli Indiani",new Author(1,"Agatha","Christie"),new Publisher(1,"Mondadori"),new BigDecimal(10.5)));
//			arg.addBook(new Book(2,"The Java Programming Language",new Author[] {new Author(2,"Ken","Arnolds"),new Author(3,"James","Gosling"),new Author(4,"David","Holmes")},new Publisher(2,"Addison-Wesley Professional"),new BigDecimal(10.5)));
//			assertNotNull(in);
//			lib.loadBooks(in,null);
//			lib.saveArchive();
//			Library lib2 = Library.loadArchive();
//			assertTrue(lib.getBooks().equals(lib2.getBooks()));
//		} catch(IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//			fail("It didnt work");
//		}
//		
//	}
//	
//	@Test
//	public void testLoadAllBooks() throws IOException {
//		Library app = new Library();
//		try (InputStream is = this.getClass().getResourceAsStream("/books.txt");) {
//			app.loadBooks(is, nullPrintStream);
//			assertNotNull(app.getBooks());
//			assertEquals(2, app.getBooks().size());
//		}
//	}
//
//	@Test
//	public void testAddExistentBook() throws ClassNotFoundException, IOException {
//		Library app = new Library();
//		try (InputStream is = this.getClass().getResourceAsStream("/books.dat");) {
//			app.loadArchive(is);
//		}
//		assertNotNull(app.getBooks());
//		int originalSize = app.getBooks().size();
//		Book containedBook = app.getBooks().iterator().next();
//		app.addBook(new Book(containedBook.getId(), "", new Author(0,null,null)));
//		assertEquals(originalSize, app.getBooks().size());
//	}
//	
//	@Test
//	public void testXAuthorsNotDuplicate() throws ClassNotFoundException,IOException {
//		Library app = new Library();
//		try (InputStream is = this.getClass().getResourceAsStream("/books.dat");) {
//			app.loadArchive(is);
//		}
//		//app.addBook(new Book(45,"Prova",new Author(1,"Agatha","Christie")));
//		for(Author author : app.booksByAuthor.keySet()) {
//			for(Book b : app.booksByAuthor.get(author)) {
//				for(Author a : b.getAuthor()) {
//					if(a.equals(author)) {
//						assertTrue(a==author);
//						break;
//					}
//				}
//			}
//		} 
//	}
//	
//	@Test
//	public void testSearchBookByTitleAfterRemove() throws ClassNotFoundException, IOException {
//		Library app = new Library();
//		try (InputStream is = this.getClass().getResourceAsStream("/books.dat");) {
//			System.out.println(this.getClass().getResource("/books.dat"));
//			app.loadArchive(is);
//		}
//		String title = "Dieci Piccoli Indiani";
//		Book[] searchResult = app.searchBooksByTitle(title);
//		app.removeBook(searchResult[0]);
//		searchResult = app.searchBooksByTitle(title);
//		assertEquals(0, searchResult.length);
//	}
//	
//	@Test
//	public void testSearchBookByAuthorAfterRemove() throws ClassNotFoundException, IOException {
//		Library app = new Library();
//		try (InputStream is = this.getClass().getResourceAsStream("/books.dat");) {
//			System.out.println(this.getClass().getResource("/books.dat"));
//			app.loadArchive(is);
//		}
//		assertNotNull(app.getBooks());
//		assertFalse(app.getBooks().isEmpty());
//		Author author = new Author(1, "Agatha", "Christie");
//		app.addBook(new Book(5,"Orient Express", author));
//		Book[] searchResult = app.searchBooksByAuthor(author);
//		app.removeBook(searchResult[0]);
//		searchResult = app.searchBooksByAuthor(author);
//		assertEquals(1, searchResult.length);
//	}
//	
}
