package com.benfante.javacourse.thelibrary.core.dao.jpa;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactoryCreator;
import com.benfante.javacourse.thelibrary.core.model.Author;

public class JpaAuthorDaoTest {

	static DaoFactory instance;
	static Set<Author> popAuthor = new HashSet<>();
	
	
	@BeforeClass
	public static void dbSetUp() {
		Properties configuration = new Properties();
		configuration.setProperty(DaoFactoryCreator.JPA_DAO_FACTORY_PERSISTENCE_UNIT_NAME_PARAM, "com.benfante.javacourse.thelibrary");
		instance = DaoFactoryCreator.getDaoFactory(DaoFactoryCreator.JPA_DAO_FACTORY, configuration);
		AuthorDao auth = instance.getAuthorDao();
		Author a = auth.getOrCreateAuthor("Ciccio", "Banana");
		popAuthor.add(a);
		popAuthor.add(auth.getOrCreateAuthor("Babau", "MiaoMiao")); 
	}
	
	@AfterClass
	public static void shutdown() throws Exception {
		instance.close();
	}
	
	@Test
	public void testFindById() {
		AuthorDao auth = instance.getAuthorDao();
		for(Author a : popAuthor) {
			assertEquals(a,auth.findById(a.getId()));
		}
	}
	
	@Test
	public void testFindByName() {
		AuthorDao authorDao = instance.getAuthorDao();
		for(Author a : popAuthor) {
			assertEquals(a,authorDao.findByFirstAndLastName(a.getFirstName(), a.getLastName()));
		}
		assertNotNull(authorDao.findByFirstAndLastName("Ciccio", "Banana"));
		assertTrue(popAuthor.contains(authorDao.findByFirstAndLastName("Ciccio", "Banana")));
	}

	@Test
	public void testGetOrCreate() {
		AuthorDao authorDao = instance.getAuthorDao();
		Author a = authorDao.getOrCreateAuthor("Babau", "MiaoMiao");
		assertTrue(popAuthor.contains(a));
		a = authorDao.getOrCreateAuthor("Ciccio", "Bello");
		assertFalse(popAuthor.contains(a));
		assertEquals(a,authorDao.findById(a.getId())); // just double checking
		assertEquals(a.getId(), authorDao.findById(a.getId()).getId());
	}
	
	@Test
	public void testGetOrCreateName() {
		JpaAuthorDao authorDao = (JpaAuthorDao) instance.getAuthorDao();
		for(Author a : popAuthor) {
			assertEquals(a.getFullName(),authorDao.getOrCreateFullName(a.getFirstName(), a.getLastName()));
			assertEquals(a.getFullName().getId(), authorDao.getOrCreateFullName(a.getFirstName(), a.getLastName()).getId());
		}
	}
	
}
