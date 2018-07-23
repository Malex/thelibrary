package com.benfante.javacourse.thelibrary.core.dao;

import com.benfante.javacourse.thelibrary.core.model.Author;

public interface AuthorDao {
	
	public Author getOrCreateAuthor(String firstName,String lastName);
	
	public Author searchAuthorByFirstAndLastName(String firstName,String lastName);
}
