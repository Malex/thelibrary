package com.benfante.javacourse.thelibrary.core.model.comparator;

import java.io.Serializable;
import java.util.Comparator;

import com.benfante.javacourse.thelibrary.core.model.Book;

public class BookIsbnComparator implements Comparator<Book>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final BookIsbnComparator com = new BookIsbnComparator();
	
	
	public static BookIsbnComparator getInstance() {
		return com;
	}
	
	private BookIsbnComparator() {
	}

	@Override
	public int compare(Book o1, Book o2) {
		if(o1==null || o2==null) 
			return (o1==o2)?0:((o1==null)?-1:1);
		else
			return o1.getIsbn().compareToIgnoreCase(o2.getIsbn());
	}

}
