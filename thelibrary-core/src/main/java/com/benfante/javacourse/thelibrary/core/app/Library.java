package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Library {
	
	private Book[] books = new Book[0];

	public static void main(String[] args) {
		Library lib = new Library();
		long id;
		long id_p;
		long id_a;
		String titolo;
		try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in));) {
			System.out.println("Inserisci il libro: ");
			System.out.println("\tInserisci l'ID del libro: ");
			
			while((id = Long.valueOf(in.readLine()).longValue())!=-1){
				System.out.println("\tInserisci titolo: ");
				titolo = in.readLine();
				System.out.println("\tInserisci prezzo");
				//readline below
				Book b = new Book(id,titolo,new Author[0],new BigDecimal(in.readLine()));
		
				String input_a;
				String input_c;
				System.out.println("\tInserisci ID dell'Autore: ");
				while((id_a = Long.valueOf(in.readLine()).longValue())!=-1) {
					System.out.println("\tInserisci Nome Autore: ");
					input_a = in.readLine();
					System.out.println("\tInserisci Cognome Autore: ");
					input_c = in.readLine();
					b.addAuthor(new Author(id_a,input_a,input_c));
					System.out.println("\tInserisci ID dell'Autore: ");
				}

				System.out.println("\tInserisci ID dell'editore: ");
				id_p = Long.valueOf(in.readLine()).longValue();
				System.out.println("\tInserisci nome editore: ");
				b.setPublisher(new Publisher(id_p, in.readLine()));
				
				String cat = null;
				do {
					if(cat!=null) {
						try {
							b.addCategory(BookCategory.getCategory(Integer.valueOf(cat).intValue()-1));
						} catch(IllegalArgumentException e) {
							System.out.println("Tale categoria non rientra in quelle previste. Riprova.");
							cat = null;
							continue;
						}
					}
					System.out.println("\tCategorie disponibili: ");
					int count = 1;
					for(BookCategory g : BookCategory.values())
						System.out.println((count++)+". "+g.toString());
					
					System.out.println("\tInserisci una categoria: ");
					cat = in.readLine();
				} while(! "X".equals(cat));
				
				lib.addBook(b);
				
				System.out.println("Inserisci il libro: ");
				System.out.println("\tInserisci l'ID del libro: ");

			}
		} catch(IOException e) {
			System.out.println("An Error has occured while reading input");
		}
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
		int hash = book.hashCode();
		boolean found = false;
		for (int i=0; i < this.books.length; i++) {
			if(this.books[i].hashCode() == hash && this.books[i].equals(book)) {
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
	void trimBooks() {
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
	

	Book[] getBooks() {
		return this.books;
	}

	
	public void printBooks() {
		for(Book g : this.getBooks()) {
			System.out.println(g.getPrint()+"\n");
		}
	}
	
}
