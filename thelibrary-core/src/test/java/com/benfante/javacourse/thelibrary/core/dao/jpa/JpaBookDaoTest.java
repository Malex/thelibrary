package com.benfante.javacourse.thelibrary.core.dao.jpa;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactoryCreator;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;
import com.benfante.javacourse.thelibrary.core.model.FullName;
import com.benfante.javacourse.thelibrary.core.model.Publisher;

public class JpaBookDaoTest {

	static DaoFactory instance;
	static Collection<Book> popBook = new HashSet<>();
	
	
	@Before
	public void dbSetUp() {
		Properties configuration = new Properties();
		configuration.setProperty(DaoFactoryCreator.JPA_DAO_FACTORY_PERSISTENCE_UNIT_NAME_PARAM, "com.benfante.javacourse.thelibrary-test");
		instance = DaoFactoryCreator.getDaoFactory(DaoFactoryCreator.JPA_DAO_FACTORY, configuration);
		BookDao b = instance.getBookDao();
		Book a = b.store(new Book("1111-0000-11","Ciccio va al mare",new Author(1,"Gianni","Levada"),new Publisher("Mondadori"),BigDecimal.valueOf(16.4)));
		popBook.add(a);
		a = b.store(new Book("1111-03500-11","Cucciolo di vita",new Author(1,"Gianni","Levada"),new Publisher("Mondadori"),BigDecimal.valueOf(32)));
		popBook.add(a);
		a = b.store(new Book("1111-03530-11","Cucciolo di vita",new Author(2,"Janus","Caputo"),new Publisher("Hoepli"),BigDecimal.valueOf(0.12)));
		popBook.add(a);
	}
	
	@Test
	public void testFindAll() {
		BookDao b = instance.getBookDao();
		Collection<Book> col = b.findAll();
		assertEquals(3, col.size());
		assertEquals(popBook,new HashSet<>(col));
	}

	@Test
	public void testFindByIsbn() {
		BookDao b = instance.getBookDao();
		Book col = b.findByIsbn("1111-0000-11");
		assertNotNull(col);
		assertTrue(popBook.contains(col));
		assertNull(b.findByIsbn("115"));
	}

	@Test
	public void testFindByTitle() {
		BookDao b = instance.getBookDao();
		Book[] col = b.findByTitle("Ciccio va al mare");
		assertEquals(1, col.length);
		assertTrue(popBook.containsAll(Arrays.asList(col)));
		col = b.findByTitle("Cucciolo di vita");
		assertEquals(2, col.length);
		assertTrue(popBook.containsAll(Arrays.asList(col)));
	}

	@Test
	public void testFindByAuthor() {
		BookDao b = instance.getBookDao();
		Book[] col = b.findByAuthor(new Author(1,"Gianni","Levada"));
		assertEquals(2, col.length);
		assertTrue(popBook.containsAll(Arrays.asList(col)));
		col = b.findByAuthor(new Author(2,"Janus","Caputo"));
		assertEquals(1, col.length);
		assertTrue(popBook.containsAll(Arrays.asList(col)));
	}

	@Test
	public void testStore() {
		BookDao b = instance.getBookDao();
		b.store(new Book("1111-0000-11","Ciccio va al mare",new Author(1,"Gianni","Levada"),new Publisher("Mondadori"),BigDecimal.valueOf(16.4)));
		b.store(new Book("1111-00030-11","Ciccio va al mare",new Author(1,"Gianni","Levada"),new Publisher("Mondadori"),BigDecimal.valueOf(16.4)));
		Collection<Book> col = b.findAll();
		assertEquals(4, col.size());
	}

	@Test
	public void testRemove() {
		BookDao b = instance.getBookDao();
		List<Book> col = (List<Book>) b.findAll();
		assertEquals(3, col.size());
		b.remove(col.get(0));
		Collection<Book> col2 = b.findAll();
		assertEquals(2, col2.size());
	}

}
