package com.benfante.javacourse.thelibrary.core.dao.serialization;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class SerializationStorage implements Serializable {
	private static final long serialVersionUID = 1L;

	Collection<Book> books = new HashSet<>();

	Map<String,Collection<Book>> booksByTitle = new HashMap<>(); 
	Map<Author,Collection<Book>> booksByAuthor = new HashMap<>();
	Map<String,Book> booksByIsbn = new HashMap<>(); 

}
