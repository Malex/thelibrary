package com.benfante.javacourse.thelibrary.core.model.utils;

import java.util.Comparator;

import com.benfante.javacourse.thelibrary.core.model.Book;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		if (o1.hashCode() != o2.hashCode()) // NullPointerException is raised here automatically
			return calcComp(o1,o2);
		else if (o1.equals(o2))
			return 0;
		else
			return calcComp(o1,o2);
	}

	protected int calcComp(Book o1,Book o2) {
		try {
			return (o1.getIsbn().compareTo(o2.getIsbn()) < 0) ? -1 : 1;
		} catch (NullPointerException e) {
			throw new ClassCastException("Isbn of book not initialized, comparison impossible");
		}
	}
}
