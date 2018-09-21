package com.benfante.javacourse.thelibrary.core.dao.serialization;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.model.Author;

public class SerializationAuthorDao implements AuthorDao {

	private SerializationStorage serializationStorage;
	
	public SerializationAuthorDao(SerializationStorage serializationStorage) {
		this.serializationStorage = serializationStorage;
	}
	
	@Override
	public Author getOrCreateAuthor(String firstName, String lastName) {
		long new_id = 0;
		for(Author a : serializationStorage.booksByAuthor.keySet()) {
			if(a.getFirstName().equals(firstName) && a.getLastName().equals(lastName))  
				return a;
			new_id = (a.getId()>=new_id)?a.getId()+1:new_id;
		}
		return new Author(new_id,firstName,lastName);
	}

	@Override
	public Author findByFirstAndLastName(String firstName, String lastName) {
		for(Author a : serializationStorage.booksByAuthor.keySet())
			if(a.getFirstName().equals(firstName) && a.getLastName().equals(lastName))  
				return a;
		return null;
	}

	@Override
	public Author findById(long id) {
		for(Author a : serializationStorage.booksByAuthor.keySet())
			if(a.getId() == id) 
				return a;
		return null;
	}

}
