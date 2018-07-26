package com.benfante.javacourse.thelibrary.core.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.FullName;

public class JpaAuthorDao implements AuthorDao {

	private EntityManagerFactory emf;
	
	public JpaAuthorDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public Author getOrCreateAuthor(String firstName, String lastName) {
		FullName authorName = this.getOrCreateFullName(firstName, lastName);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Author> q = cb.createQuery(Author.class);
		Root<Author> root = q.from(Author.class);
		q.where(cb.equal(root.get("name"), authorName));
		Author result;
		try {
			result = em.createQuery(q).getSingleResult();
		} catch (NoResultException e) {
			result = new Author(authorName);
			em.persist(result);
		}
		em.getTransaction().commit();
		em.close();
		return result;
	}

	FullName getOrCreateFullName(String firstName, String lastName) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FullName> q = cb.createQuery(FullName.class);
		Root<FullName> root = q.from(FullName.class);
		q.where(cb.like(root.get("firstName"),firstName),cb.like(root.get("lastName"), lastName));
		FullName result;
		try {
			result = em.createQuery(q).getSingleResult();
		} catch (NoResultException e) {
			result = new FullName(firstName, lastName);
			em.persist(result);
		}
		em.getTransaction().commit();
		em.close();
		return result;
	}
	
	@Override
	public Author findByFirstAndLastName(String firstName, String lastName) {
		FullName fullname = this.getOrCreateFullName(firstName, lastName);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Author> q = cb.createQuery(Author.class);
		Root<Author> root = q.from(Author.class);
		q.where(cb.equal(root.get("name"), fullname));
		Author result = em.createQuery(q).getSingleResult();
		em.getTransaction().commit();
		em.close();
		return result;
	}

	@Override
	public Author findById(long id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Author.class,id);
	}

}
