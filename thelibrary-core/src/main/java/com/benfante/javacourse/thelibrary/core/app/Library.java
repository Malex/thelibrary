package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.dao.AuthorDao;
import com.benfante.javacourse.thelibrary.core.dao.BookDao;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactory;
import com.benfante.javacourse.thelibrary.core.dao.DaoFactoryCreator;

import com.benfante.javacourse.thelibrary.core.model.*;
import com.benfante.javacourse.thelibrary.core.model.utils.BookUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Library {
	private static final Logger log = LoggerFactory.getLogger(Library.class);
	
	private DaoFactory factory = DaoFactoryCreator.getDaoFactory();
	private BookDao bookDao = factory.getBookDao();
	private AuthorDao authorDao = factory.getAuthorDao();
	
	public Library() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					log.info("Destroying the library object, saving library data.");
					factory.close();
				} catch (Exception e) {
					log.error("Cant close DaoFactory in Library main run");
				}
			}
		});
	}
	
	public static void main(String[] args) {
		Library lib = new Library();
		lib.bookDao.findAll();
		lib.runApp(System.in);
		lib.printBooks();
		
	}

	
//	@Override
//	protected void finalize() throws Throwable {
//		log.info("Destroying the library object, saving library data.");
//		this.factory.close();
//		super.finalize();
//	}


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
		
		printLine(out,"\tInserisci le categorie separate da uno spazio (termina con X): ");
		String cat = in.readLine();
		outer:
		do { 
			for(Character c : cat.toCharArray()) {
				if(c==' ')
					continue;
				if(Character.valueOf('X').equals(c) || Character.valueOf('x').equals(c))
					break outer;
				try {
					b.addCategory(BookCategory.getCategory(Integer.parseInt(String.valueOf(c))-1));
					System.out.println(b);
				} catch(IllegalArgumentException e) {
					printLine(out,"Tale categoria non rientra in quelle previste. Riprova.");
				}
			}
			return true;
		} while(false);
		return false;
	}
	
	private boolean loadBook(BufferedReader in, BufferedWriter out) throws IOException {
		long id;
		printLine(out,"Inserisci il libro: ");
		printLine(out,"\tInserisci l'ID del libro: ");
		if((id = Long.parseLong(in.readLine()))==-1) {
			return false;
		}
		long id_p;
		String titolo;
		printLine(out,"\tInserisci l'Isbn del libro: ");
		String isbn = in.readLine();
		printLine(out,"\tInserisci titolo: ");
		titolo = in.readLine();
		printLine(out,"\tInserisci prezzo");
		//readline below
		Book b = BookUtil.generateBook(id,isbn,titolo,new LinkedList<Author>(),new BigDecimal(in.readLine()));

		
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
	
	
//	public Library(Book book) {
//		this.addBook(book);
//	}
//	
//	public Library(Book[] books) {
//		this.addBooks(books);
//	}
	
	
	public void printBooks() {
		for(Book g : this.getBooks()) {
			System.out.println(g.toString()+"\n");
		}
	}
	
	Collection<Book> getBooks() {
		return this.bookDao.findAll();
	}
	
	
}
