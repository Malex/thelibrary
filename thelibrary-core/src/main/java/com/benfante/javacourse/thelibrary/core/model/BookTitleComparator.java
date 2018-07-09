package com.benfante.javacourse.thelibrary.core.model;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

	@Override
	public int compare(Book arg0, Book arg1) {
		if(arg0==null || arg1==null) 
			return (arg0==arg1)?0:((arg0==null)?-1:1);
		else {
			return arg0.getTitle().compareToIgnoreCase(arg1.getTitle());
		}
	}

}
