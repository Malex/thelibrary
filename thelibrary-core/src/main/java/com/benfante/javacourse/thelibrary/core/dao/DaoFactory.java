package com.benfante.javacourse.thelibrary.core.dao;

public interface DaoFactory {

	public BookDao getBookDao(); 
	
	public AuthorDao getAuthorDao();
	
}
