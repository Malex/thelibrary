package com.benfante.javacourse.thelibrary.core.dao;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.Persistence;

import com.benfante.javacourse.thelibrary.core.dao.jpa.JpaDaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.serialization.SerializationDaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.serialization.SerializationStorage;

public class DaoFactoryCreator {
	public static final byte SERIALIZATION_DAO_FACTORY = 1;
	public static final byte JPA_DAO_FACTORY = 2;
	public static final String SERIALIZATION_DAO_FACTORY_ARCHIVE_PARAM = "serializationDaoFactory.archive";
	public static final String JPA_DAO_FACTORY_PERSISTENCE_UNIT_NAME_PARAM = "jpaDaoFactory.persistenceUnitName";
	
	private static DaoFactory serializationDaoFactory;
	private static DaoFactory jpaDaoFactory;
	
	public static DaoFactory getDaoFactory() {
		Properties configuration = new Properties();
		configuration.setProperty(SERIALIZATION_DAO_FACTORY_ARCHIVE_PARAM, "archive.dat");
		return getDaoFactory(SERIALIZATION_DAO_FACTORY,configuration );
	}
	
	public static DaoFactory getDaoFactory(byte daoFactoryType, Properties configuration) {
		DaoFactory res = null;
		switch(daoFactoryType) {
		
			case JPA_DAO_FACTORY:
				if(jpaDaoFactory==null || !(jpaDaoFactory instanceof JpaDaoFactory))
					res = new JpaDaoFactory(Persistence.createEntityManagerFactory(
							configuration.getProperty(JPA_DAO_FACTORY_PERSISTENCE_UNIT_NAME_PARAM)));
				else 
					res = jpaDaoFactory;
				break;
				
			case SERIALIZATION_DAO_FACTORY:
			default:
				try {
					if(serializationDaoFactory==null || ! (serializationDaoFactory instanceof SerializationDaoFactory))
						res = new SerializationDaoFactory(new SerializationStorage(
								configuration.getProperty(SERIALIZATION_DAO_FACTORY_ARCHIVE_PARAM)));
					else 
						res = serializationDaoFactory;
				} catch (ClassNotFoundException | IOException e) {
					throw new RuntimeException("Error creating a SerializationDaoFactory",e);
				}
				break;
		}
		return res;
	}
	
}
