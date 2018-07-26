package com.benfante.javacourse.thelibrary.core.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class JpaBookDao implements BookDao {
	private EntityManagerFactory em;
	
	private static final Book[] runtimeArr = new Book[0];
	
	public JpaBookDao(EntityManagerFactory em) {
		this.em = em;
	}
	
	@Override
	public Collection<Book> findAll() {
		EntityManager em = this.em.createEntityManager();
		return em.createQuery("Book.findAll", Book.class).getResultList();
	}

	@Override
	public Book findByIsbn(String isbn) {
		EntityManager em = this.em.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> q = cb.createQuery(Book.class);
		Root<Book> root = q.from(Book.class);
		q.where(cb.equal(root.get("isbn"), isbn));
		Book result = em.createQuery(q).getSingleResult();
		em.getTransaction().commit();
		em.close();
		return result;
	}

	@Override
	public Book[] findByTitle(String title) {
		EntityManager em = this.em.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> q = cb.createQuery(Book.class);
		Root<Book> root = q.from(Book.class);
		q.where(cb.equal(root.get("title"), title));
		List<Book> result = em.createQuery(q).getResultList();
		em.getTransaction().commit();
		em.close();
		return result.toArray(runtimeArr);
	}

	@Override
	public Book[] findByAuthor(Author author) {
		EntityManager em = this.em.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Book> q = cb.createQuery(Book.class);
		Root<Book> root = q.from(Book.class);
		CriteriaQuery<Author> q2 = cb.createQuery(Author.class);
		Root<Author> root2 = q2.from(Author.class);
		Predicate pr = root.get("author").in(root2.get("book"));
		q.where(pr);
		List<Book> result = em.createQuery(q).getResultList();
		em.getTransaction().commit();
		em.close();
		return result.toArray(runtimeArr);
	}

	@Override
	public Book store(Book book) {
		EntityManager em = this.em.createEntityManager();
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		em.close();
		return book;
	}

	@Override
	public void remove(Book book) {
		EntityManager em = this.em.createEntityManager();
		em.getTransaction().begin();
		em.remove(book);
		em.getTransaction().commit();
		em.close();
	}

}
