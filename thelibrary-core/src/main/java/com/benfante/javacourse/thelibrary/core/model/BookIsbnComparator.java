package com.benfante.javacourse.thelibrary.core.model;

import java.util.Comparator;

public class BookIsbnComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		if(o1==null || o2==null) 
			return (o1==o2)?0:((o1==null)?-1:1);
		else
			return o1.getIsbn().compareToIgnoreCase(o2.getIsbn());
	}

}
