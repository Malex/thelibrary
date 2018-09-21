package com.benfante.javacourse.thelibrary.core.dao.jpa;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactoryCreator;

public class JpaDaoFactoryTest {
	
	static DaoFactory instance;
	
	@BeforeClass
	public static void setUp() {
		Properties configuration = new Properties();
		configuration.setProperty(DaoFactoryCreator.JPA_DAO_FACTORY_PERSISTENCE_UNIT_NAME_PARAM, "com.benfante.javacourse.thelibrary-test");
		instance = DaoFactoryCreator.getDaoFactory(DaoFactoryCreator.DaoFactoryType.JPA_DAO_FACTORY, configuration);
	}

	@AfterClass
	public static void shutDown() throws Exception {
		instance.close();
	}

	@Test
	public void testGetBookDao() {
		assertNotNull(instance.getBookDao());
	}

	@Test
	public void testGetAuthorDao() {
		assertNotNull(instance.getAuthorDao());
	}

	
	
}
