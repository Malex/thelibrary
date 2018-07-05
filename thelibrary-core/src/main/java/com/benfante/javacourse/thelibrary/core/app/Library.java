package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.model.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class Library {
	
	private Book[] books = new Book[0];

	public static void main(String[] args) {
		Library lib = new Library();
		lib.runApp(System.in);
		lib.printBooks();
		
	}

	
	public static void printLine(BufferedWriter out,String s) throws IOException {
		out.write(s);
		out.newLine();
		out.flush();
	}
	
	
	public void loadBooks(InputStream inp,OutputStream Out) throws IOException {
		if(Out==null) {
			Out = new OutputStream() { @Override public void write(int b) { } };
		}
		long id;
		long id_p;
		long id_a;
		String titolo;
		BufferedReader in = new BufferedReader(new InputStreamReader(inp));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Out));
		printLine(out,"Inserisci il libro: ");
		printLine(out,"\tInserisci l'ID del libro: ");
			
		while((id = Long.parseLong(in.readLine()))!=-1){
			printLine(out,"\tInserisci titolo: ");
			titolo = in.readLine();
			printLine(out,"\tInserisci prezzo");
			//readline below
			Book b = new Book(id,titolo,new Author[0],new BigDecimal(in.readLine()));
	
			String input_a;
			String input_c;
			printLine(out,"\tInserisci ID dell'Autore: ");
			while((id_a = Long.parseLong(in.readLine()))!=-1) {
				printLine(out,"\tInserisci Nome Autore: ");
				input_a = in.readLine();
				printLine(out,"\tInserisci Cognome Autore: ");
				input_c = in.readLine();
				b.addAuthor(new Author(id_a,input_a,input_c));
				printLine(out,"\tInserisci ID dell'Autore: ");
			}

			printLine(out,"\tInserisci ID dell'editore: ");
			id_p = Long.parseLong(in.readLine());
			printLine(out,"\tInserisci nome editore: ");
			b.setPublisher(new Publisher(id_p, in.readLine()));
			
			String cat = null;
			do {
				if(cat!=null) {
					try {
						b.addCategory(BookCategory.getCategory(Integer.valueOf(cat).intValue()-1));
					} catch(IllegalArgumentException e) {
						printLine(out,"Tale categoria non rientra in quelle previste. Riprova.");
						out.newLine();
						cat = null;
						continue;
					}
				}
				printLine(out,"\tCategorie disponibili: ");
				int count = 1;
				for(BookCategory g : BookCategory.values()) {
					printLine(out,(count++)+". "+g.toString());
				}
				printLine(out,"X Fine inserimento categorie");
				
				printLine(out,"\tInserisci una categoria: ");
				cat = in.readLine();
			} while(! "X".equals(cat));
			
			this.addBook(b);
			
			printLine(out,"Inserisci il libro: ");
			printLine(out,"\tInserisci l'ID del libro: ");
		}

	}
	
	
	public void runApp(InputStream inp) {
		try {
			this.loadBooks(inp, System.out);
		} catch (IOException e) {
			System.out.println("An error has occured");
		}
		this.printBooks();
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

	
	public void saveArchive() {
		try(ObjectOutputStream oj = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(this.getClass().getResource("/books.dat").getFile()))));) {
			oj.writeObject(this.getBooks());
		} catch(IOException e) {
			System.out.println("Couldnt create output .dat archive");
			e.printStackTrace();
		}
	}
	
	public static Library loadArchive() throws ClassNotFoundException {
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Library.class.getResourceAsStream("/books.dat"))); ) {
			Library ret = new Library();
			ret.addBooks((Book[]) in.readObject());
			return ret;
		} catch(IOException e) {
			System.out.println("Couldnt find archive to load");
		}
		throw new RuntimeException("No return to make");
	}
	
	
}
