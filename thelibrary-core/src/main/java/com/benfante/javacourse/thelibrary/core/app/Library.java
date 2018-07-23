package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.dao.serialization.SerializationBookDao;
import com.benfante.javacourse.thelibrary.core.dao.serialization.SerializationStorage;
import com.benfante.javacourse.thelibrary.core.model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;


public class Library {
	
	private SerializationStorage serializationStorage;
	private BookDao bookDao;
	
	public static void main(String[] args) {
		Library lib = new Library();
		lib.runApp(System.in);
		lib.printBooks();
		
	}

	
	private static void printLine(BufferedWriter out,String s) throws IOException {
		out.write(s);
		out.newLine();
		out.flush();
	}
	
	
	private boolean loadAuthor(BufferedReader in,BufferedWriter out,Book b) throws IOException {
		long id_a;
		String input_a;
		String input_c;
		printLine(out,"\tInserisci ID dell'Autore: ");
		if((id_a = Long.parseLong(in.readLine())) == -1)
			return false;
		printLine(out,"\tInserisci Nome Autore: ");
		input_a = in.readLine();
		printLine(out,"\tInserisci Cognome Autore: ");
		input_c = in.readLine();
		Author a = new Author(id_a,input_a,input_c);
		b.addAuthor(a);
		return true;
	}
	
	private boolean loadCategory(BufferedReader in, BufferedWriter out, Book b) throws IOException {
		printLine(out,"\tCategorie disponibili: ");
		int count = 1;
		for(BookCategory g : BookCategory.values()) {
			printLine(out,(count++)+". "+g.toString());
		}
		printLine(out,"X Fine inserimento categorie");
		
		printLine(out,"\tInserisci una categoria: ");
		String cat = in.readLine();
		if("X".equals(cat) || "x".equals(cat))
			return false;
		try {
			b.addCategory(BookCategory.getCategory(Integer.parseInt(cat)-1));
		} catch(IllegalArgumentException e) {
			printLine(out,"Tale categoria non rientra in quelle previste. Riprova.");
		}
		return true;
	}
	
	private boolean loadBook(BufferedReader in, BufferedWriter out) throws IOException {
		long id;
		printLine(out,"Inserisci il libro: ");
		printLine(out,"\tInserisci l'ID del libro: ");
		if((id = Long.parseLong(in.readLine()))==-1)
			return false;
		long id_p;
		String titolo;
		
		printLine(out,"\tInserisci titolo: ");
		titolo = in.readLine();
		printLine(out,"\tInserisci prezzo");
		//readline below
		Book b = new Book(id,titolo,new Author[0],new BigDecimal(in.readLine()));

		
		while(loadAuthor(in,out,b)) {}

		printLine(out,"\tInserisci ID dell'editore: ");
		id_p = Long.parseLong(in.readLine());
		printLine(out,"\tInserisci nome editore: ");
		b.setPublisher(new Publisher(id_p, in.readLine()));
		
		while(loadCategory(in, out, b)) {}
		
		this.bookDao.store(b);
		return true;
		
	}
	
	public void loadBooks(InputStream inp,OutputStream Out) throws IOException {
		if(Out==null) {
			Out = new OutputStream() { @Override public void write(int b) { } };
		}

	
		BufferedReader in = new BufferedReader(new InputStreamReader(inp));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Out));
		
		while(loadBook(in, out)) {}
	}
	
	
	public void runApp(InputStream inp) {
		try {
			this.loadBooks(inp, System.out);
		} catch (IOException e) {
			System.out.println("An error has occured");
		}
	}
	
	public Library() {
		 try {
			 this.serializationStorage = new SerializationStorage("archive.dat");
			 this.bookDao = new SerializationBookDao(this.serializationStorage);

		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}
	
//	public Library(Book book) {
//		this.addBook(book);
//	}
//	
//	public Library(Book[] books) {
//		this.addBooks(books);
//	}
	
	
	public void printBooks() {
		for(Book g : this.bookDao.findAll()) {
			System.out.println(g.toString()+"\n");
		}
	}
	
}
