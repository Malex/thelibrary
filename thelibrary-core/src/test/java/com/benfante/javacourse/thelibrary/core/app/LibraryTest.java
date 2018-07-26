package com.benfante.javacourse.thelibrary.core.app;




import static org.junit.Assert.*;

import java.io.*;


import org.junit.Test;

public class LibraryTest {
	private OutputStream nullPrintStream =
			new OutputStream() {
				@Override
				public void write(int b) throws IOException {
				}
			};
//	
//	

//	

//

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
//		
//	}
//
//	@Test
//	public void testSearchBooksByAuthor() {

//	}
//

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
		@Test
		public void testLoadAllBooks() throws IOException {
			Library app = new Library();
			try (InputStream is = this.getClass().getResourceAsStream("/books.txt");) {
				app.loadBooks(is, nullPrintStream);
				assertNotNull(app.getBooks());
				assertEquals(2, app.getBooks().size());
			}
		}
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

//	

//	
	
//	@Test
//	public void testLoadBooks() {
//		Library lib = new Library();
//		try(InputStream in = this.getClass().getResourceAsStream("/books.txt")){
//			SerializationStorage arg = new SerializationStorage();
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
}
