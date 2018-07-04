package com.benfante.javacourse.thelibrary.core.model;

public enum BookCategory {
	OTHER, 
	ARTS_AND_PHOTOGRAPHY,
	HISTORY,
	LITERATURE_AND_FICTION;
	
	@Override
	public String toString() {
		switch(this) {
			case OTHER:
				return "Other";
			case ARTS_AND_PHOTOGRAPHY:
				return "Arts and Photography";
			case HISTORY:
				return "History";
			case LITERATURE_AND_FICTION:
				return "Literature and Fiction";
		}
		return "";//just to suppress error
	}
}
