package com.benfante.javacourse.thelibrary.core.dao;

public interface DaoFactory extends AutoCloseable {

	BookDao getBookDao(); 
	AuthorDao getAuthorDao();

}