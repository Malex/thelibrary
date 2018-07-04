package com.benfante.javacourse.thelibrary.core.model;

public enum BookCategory {
	OTHER("Other"), 
	ARTS_AND_PHOTOGRAPHY("Arts and Photography"),
	COMPUTERS_AND_TECHNOLOGY("Computers and Technology"),
	HISTORY("History"),
	LITERATURE_AND_FICTION("Literature and Fiction");

	private String nameValue;
	
	BookCategory(String s) {
		this.nameValue = s;
	}

	@Override
	public String toString() {
		return this.nameValue;
	}
	
}
