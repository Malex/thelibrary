package com.benfante.javacourse.thelibrary.core.dao;

import java.io.IOException;

import com.benfante.javacourse.thelibrary.core.dao.serialization.SerializationDaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.serialization.SerializationStorage;

public class DaoFactoryCreator {
	private static SerializationStorage storage;
	private static DaoFactory factory;
	
	static {
		try {
			storage = new SerializationStorage("archive.dat");
			factory = new SerializationDaoFactory(storage);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DaoFactory getDaoFactory() {
		return factory;
	}
}
