package com.benfante.javacourse.thelibrary.core.dao.jpa;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
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
	
	
	@BeforeClass
	public static void dbSetUp() {
		Properties configuration = new Properties();
		configuration.setProperty(DaoFactoryCreator.JPA_DAO_FACTORY_PERSISTENCE_UNIT_NAME_PARAM, "com.benfante.javacourse.thelibrary");
		instance = DaoFactoryCreator.getDaoFactory(DaoFactoryCreator.JPA_DAO_FACTORY, configuration);
		BookDao b = instance.getBookDao();
		AuthorDao au = instance.getAuthorDao();
		Book a = b.store(new Book("1111-0000-11","Ciccio va al mare",new Author(new FullName("Gianni","Levada")),new Publisher("Mondadori"),BigDecimal.valueOf(16.4)));
		popBook.add(a);
		a = b.store(new Book("1111-03500-11","Cucciolo di vita",au.getOrCreateAuthor("Gianni","Levada"),new Publisher("Mondadori"),BigDecimal.valueOf(32)));
		popBook.add(a);
		a = b.store(new Book("1111-03530-11","Cucciolo di vita",au.getOrCreateAuthor("Janus","Caputo"),new Publisher("Hoepli"),BigDecimal.valueOf(0.12)));
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
		//fail("Not yet implemented");
	}

	@Test
	public void testStore() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		//fail("Not yet implemented");
	}

}
