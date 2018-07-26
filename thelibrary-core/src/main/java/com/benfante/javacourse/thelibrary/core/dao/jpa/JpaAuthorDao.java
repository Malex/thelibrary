package com.benfante.javacourse.thelibrary.core.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
		// TODO Auto-generated method stub
		return null;
	}

	private FullName getOrCreateFullName(String firstName, String lastName) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FullName> q = cb.createQuery(FullName.class);
		Root<FullName> root = q.from(FullName.class);
		q.where(null)
	}
	
	@Override
	public Author findByFirstAndLastName(String firstName, String lastName) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Author> q = cb.createQuery(Author.class);
		Root<Author> root = q.from(Author.class);
		FullName fullname = this.getOrCreateFullName(firstName, lastName);
		q.where(cb.equal(root.get("fullname"), fullname));
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
