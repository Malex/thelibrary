package com.benfante.javacourse.thelibrary.core.dao.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class JpaBookDao implements BookDao {
	private EntityManager em;
	
	public JpaBookDao(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Collection<Book> findAll() {
		return em.createQuery("from book", Book.class).getResultList();
	}

	@Override
	public Book findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book[] findByAuthor(Author author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book store(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Book book) {
		// TODO Auto-generated method stub

	}

}
