package com.benfante.javacourse.thelibrary.core.dao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;

public class JpaDaoFactory implements DaoFactory {

	private EntityManagerFactory entityManagerFactory;
		
	
	public JpaDaoFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public void close() throws Exception {
		entityManagerFactory.close();

	}

	@Override
	public BookDao getBookDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthorDao getAuthorDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
