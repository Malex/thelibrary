package com.benfante.javacourse.thelibrary.core.dao.serialization;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;

public class SerializationDaoFactory implements DaoFactory {

	private SerializationStorage serializationStorage;
	
	public SerializationDaoFactory(SerializationStorage serializationStorage) {
		this.serializationStorage = serializationStorage;
	}
	
	
	@Override
	public BookDao getBookDao() {
		return new SerializationBookDao(this.serializationStorage);
	}

	@Override
	public AuthorDao getAuthorDao() {
		return new SerializationAuthorDao(this.serializationStorage);
	}

}
