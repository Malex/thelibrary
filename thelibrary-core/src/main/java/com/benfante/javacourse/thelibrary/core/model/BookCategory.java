package com.benfante.javacourse.thelibrary.core.model;

import java.io.Serializable;

public enum BookCategory implements Serializable {
	OTHER("Other"), 
	ARTS_AND_PHOTOGRAPHY("Arts and Photography"),
	COMPUTERS_AND_TECHNOLOGY("Computers and Technology"),
	HISTORY("History"),
	LITERATURE_AND_FICTION("Literature and Fiction");

	private String nameValue;
	
	BookCategory(String s) {
		this.nameValue = s;
	}

	
	public static BookCategory getCategory(int i) throws IllegalArgumentException {
		BookCategory[] categories = BookCategory.values();
		for(int j = 0;j < categories.length ; j++) {
			if(j==i) 
				return categories[j];
		}
		throw new IllegalArgumentException();
	}
	
	@Override
	public String toString() {
		return this.nameValue;
	}
	
}
