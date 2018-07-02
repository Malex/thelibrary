package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.model.*;

public class Library {
	
	private Book[] books = new Book[0];

	public static void main(String[] args) {
		Book[] book = new Book[] {new Book(1252,"Dieci Piccoli indiani",new Author(1,"JK"," Rowling"),3.14f),new Book(14272,"Due Coccodrilli",new Author(2,"James"," Cameroon"))};
		Library lib = new Library(book);
		lib.printBooks();
	}

	public Library() {
		super();
	}
	
	public Library(Book book) {
		this.addBook(book);
	}
	
	public Library(Book[] books) {
		this.addBooks(books);
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
	
	
	public Book[] searchBooksByTitle(String title) {
		Book[] tmp = new Book[this.books.length];
		int i = 0;
		for(Book g : this.books) {
			if (g.getTitle().equals(title)) {
				tmp[i] = g;
				i++;
			}
		}
		Book[] ret = new Book[i];
		for(int j=0;j<i;j++) {
			ret[j]=tmp[j];
		}
		return ret;
	}
	
	public Book[] searchBooksByAuthor(Author author) {
		Book[] tmp = new Book[this.books.length];
		int i = 0;
		for(Book g : this.books) {
			if (g.hasAuthor(author)) {
				tmp[i] = g;
				i++;
			}
		}
		Book[] ret = new Book[i];
		for(int j=0;j<i;j++) {
			ret[j]=tmp[j];
		}
		return ret;
	}
	

	protected Book[] getBooks() {
		return this.books;
	}

	
	public void printBooks() {
		for(Book g : this.getBooks()) {
			System.out.println(g.getPrint()+"\n");
		}
	}
	
}
