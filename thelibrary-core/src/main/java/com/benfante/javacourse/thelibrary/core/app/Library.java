package com.benfante.javacourse.thelibrary.core.app;


import com.benfante.javacourse.thelibrary.core.model.*;

public class Library {

	public static void main(String[] args) {
		Book book1 = new Book(1252,"Dieci Piccoli indiani","JK Rowling",3.14f);
		Book book2 = new Book(14272,"Due Coccodrilli","James Cameroon");
		
		System.out.println(book1.getPrint());
		System.out.println(book2.getPrint());
	}

}
