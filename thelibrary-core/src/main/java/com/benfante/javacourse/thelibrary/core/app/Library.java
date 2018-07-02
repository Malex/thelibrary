package com.benfante.javacourse.thelibrary.core.app;


import com.benfante.javacourse.thelibrary.core.model.*;

public class Library {
	
	private Book[] books;

	public static void main(String[] args) {
		Book book1 = new Book(1252,"Dieci Piccoli indiani",new Author(1,"JK"," Rowling"),3.14f);
		Book book2 = new Book(14272,"Due Coccodrilli",new Author(2,"James"," Cameroon"));
		
		System.out.println(book1.getPrint());
		System.out.println(book2.getPrint());
	}

	public void addBook(Book book) {
		Book[] new_books = new Book[this.books.length+1];
		for(int i=0; i<this.books.length; i++)
			new_books[i]=this.books[i];
		new_books[this.books.length] = book;
		this.books = new_books;
	}
	
	public void addBooks(Book[] books) {
		for (Book g : books)
			this.addBook(g);
	}
	
	public void removeBook(Book book) {
		long base_id = book.getId();
		boolean found = false;
		for (int i=0; i < this.books.length; i++) {
			if(this.books[i].getId() == base_id) {
				this.books[i] = null;
				if(!found) found=true;
			}
		}
		if(found)
			this.trimBooks();
	}
	
	public void removeBooks(Book[] books) {
		for (Book g : books) 
			this.removeBook(g);
	}
	
	/*Method to resize array after removing elements*/
	protected void trimBooks() {
		int count = 0,shift=0;
		for (int i=0; i < this.books.length; i++) {
			if(this.books[i]==null) { //Finding how many elements were removed, saving in count
				count++;
			}
		}
		Book[] new_book = new Book[this.books.length-count];
		
		for (int i=0; i < this.books.length-count;i++) { // Filling new array
			while(this.books[i+shift]==null) { //Counting number of blanks from location in cycle
				shift++;
			}
			new_book[i]=this.books[i+shift];
		}
		
		this.books = new_book;
	}
	
	
}
