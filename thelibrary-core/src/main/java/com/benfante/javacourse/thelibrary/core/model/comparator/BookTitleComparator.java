package com.benfante.javacourse.thelibrary.core.model.comparator;

import java.io.Serializable;
import java.util.Comparator;

import com.benfante.javacourse.thelibrary.core.model.Book;

public class BookTitleComparator implements Comparator<Book>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static final BookTitleComparator comparator = new BookTitleComparator();
	
	
	@Override
	public int compare(Book arg0, Book arg1) {
		if(arg0==null || arg1==null) 
			return (arg0==arg1)?0:((arg0==null)?-1:1);
		else {
			return arg0.getTitle().compareToIgnoreCase(arg1.getTitle());
		}
	}

	private BookTitleComparator() {
	}

	public static BookTitleComparator getInstance() {
		return comparator;
	}
	
}
