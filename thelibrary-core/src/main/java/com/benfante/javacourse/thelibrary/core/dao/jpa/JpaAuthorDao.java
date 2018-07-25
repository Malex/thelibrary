package com.benfante.javacourse.thelibrary.core.dao.jpa;

import javax.persistence.EntityManager;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.model.Author;

public class JpaAuthorDao implements AuthorDao {

	private EntityManager em;
	
	public JpaAuthorDao(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Author getOrCreateAuthor(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author findByFirstAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
