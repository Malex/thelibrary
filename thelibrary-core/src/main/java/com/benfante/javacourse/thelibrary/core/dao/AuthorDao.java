package com.benfante.javacourse.thelibrary.core.dao;

import com.benfante.javacourse.thelibrary.core.model.Author;

public interface AuthorDao {
	
	Author getOrCreateAuthor(String firstName,String lastName);
	
	Author findByFirstAndLastName(String firstName,String lastName);
	
	Author findById(long id);
}
