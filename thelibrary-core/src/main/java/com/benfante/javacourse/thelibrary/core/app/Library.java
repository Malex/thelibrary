package com.benfante.javacourse.thelibrary.core.app;

import com.benfante.javacourse.thelibrary.core.model.*;

import java.io.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Library {
	private static final Book[] runtimeArr = new Book[0]; 
	
	private Collection<Book> books = new HashSet<>();
	
	Map<String,Collection<Book>> booksByTitle = new HashMap<>(); 
	Map<Author,Collection<Book>> booksByAuthor = new HashMap<>();
	Map<String,Book> booksByIsbn = new HashMap<>(); 
	
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
		if(this.booksByAuthor.containsKey(a))
			for(Author f : this.booksByAuthor.keySet())
				if(f.hashCode()==a.hashCode())
					if(f.equals(a)) {
						a = f; break;
					}
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
		
		this.addBook(b);
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
		super();
	}
	
	public Library(Book book) {
		this.addBook(book);
	}
	
	public Library(Book[] books) {
		this.addBooks(books);
	}
	
	
	private void updateTitleMap(Book book) {
		Collection<Book> tmp = new HashSet<>();
		if(this.booksByTitle.containsKey(book.getTitle()))
			tmp.addAll(this.booksByTitle.get(book.getTitle()));
		tmp.add(book);
		this.booksByTitle.put(book.getTitle(), tmp);
	}
	private void updateAuthorMap(Book book) {
		for(Author a : book.getAuthor()) {
			Collection<Book> tmp = new HashSet<>();
			if(this.booksByAuthor.containsKey(a))
				tmp.addAll(this.booksByAuthor.get(a));
			tmp.add(book);
			this.booksByAuthor.put(a, tmp);
		}
	}
	private void updateIsbnMap(Book book) {
		if(book.getIsbn()!=null && this.booksByIsbn.containsKey(book.getIsbn()))
			throw new RuntimeException("ISBN codes must be unique");
		this.booksByIsbn.put(book.getIsbn(), book);
	}
	private void updateMaps(Book book) {
		this.updateTitleMap(book);
		this.updateAuthorMap(book);
		this.updateIsbnMap(book);
	}
	
	private Author searchAuthorById(long id) {
		for(Author a : this.booksByAuthor.keySet()) {
			if(a.getId()==id)
				return a;
		}
		return null;
	}
	public void addBook(Book book) {
//		Book[] new_books = new Book[this.books.length+1];
//		for(int i=0; i<this.books.length; i++)
//			new_books[i]=this.books[i];
//		new_books[this.books.length] = book;
//		this.books = new_books;
		Author tmp;
		Author a;
		for(int i=0;i<book.getAuthor().size();i++) {
			a = book.getAuthor().get(i);
			tmp = this.searchAuthorById(a.getId());
			if(tmp==null)
				continue;
			else
				book.getAuthor().set(i, tmp);
		}
		this.books.add(book);
		this.updateMaps(book);
	}
	
	public void addBooks(Book[] books) {
		for (Book g : books)
			this.addBook(g); 
	}
	public void addBooks(Collection<Book> books) {
		for (Book g : books)
			this.addBook(g); 
	}
	
	private void removeMapTitle(Book book) {
		this.booksByTitle.get(book.getTitle()).remove(book);
	}
	private void removeMapAuthor(Book book) {
		for(Author a : book.getAuthor())
			this.booksByAuthor.get(a).remove(book);
	}
	private void removeMapIsbn(Book book) {
		this.booksByIsbn.remove(book.getIsbn());
	}
	private void removeMap(Book book) {
		this.removeMapTitle(book);
		this.removeMapAuthor(book);
		this.removeMapIsbn(book);
	}
	public void removeBook(Book book) {
//		int hash = book.hashCode();
//		boolean found = false;
//		for (int i=0; i < this.books.length; i++) {
//			if(this.books[i].hashCode() == hash && this.books[i].equals(book)) {
//				this.books[i] = null;
//				if(!found) found=true;
//			}
//		}
//		if(found)
//			this.trimBooks();
		this.books.remove(book);
		this.removeMap(book);
	}
	
	public void removeBooks(Book[] books) {
		for(Book b : books)
			this.removeBook(b);
	}
	public void removeBooks(Collection<Book> books) {
		for(Book b : books) {
			this.removeBook(b);
		}
	}
	
	/*Method to resize array after removing elements*/
//	void trimBooks() {
//		int count = 0,shift=0;
//		for (int i=0; i < this.books.length; i++) {
//			if(this.books[i]==null) { //Finding how many elements were removed, saving in count
//				count++;
//			}
//		}
//		Book[] new_book = new Book[this.books.length-count];
//		
//		for (int i=0; i < this.books.length-count;i++) { // Filling new array
//			while(this.books[i+shift]==null) { //Counting number of blanks from location in cycle
//				shift++;
//			}
//			new_book[i]=this.books[i+shift];
//		}
//		
//		this.books = new_book;
//	}
	
	
	public Book[] searchBooksByTitle(String title) {
		return this.booksByTitle.get(title).toArray(runtimeArr);
	}
	
	public Book[] searchBooksByAuthor(Author author) {
		return this.booksByAuthor.get(author).toArray(runtimeArr);
	}
	
	public Book searchBookByIsbn(String isbn) {
		return this.booksByIsbn.get(isbn);
	}
	

	public Collection<Book> getBooks() {
		return this.books;
	}

	
	public void printBooks() {
		for(Book g : this.getBooks()) {
			System.out.println(g.toString()+"\n");
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
	
	@SuppressWarnings("unchecked")
	public void loadArchive(InputStream is) throws IOException,ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(is));
		this.addBooks((HashSet<Book>) in.readObject());
		
	}

	@SuppressWarnings("unchecked")
	public static Library loadArchive() throws ClassNotFoundException {
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Library.class.getResourceAsStream("/books.dat"))); ) {
			Library ret = new Library();
			ret.addBooks((HashSet<Book>) in.readObject());
			return ret;
		} catch(IOException e) {
			System.out.println("Couldnt find archive to load");
		}
		throw new RuntimeException("No return to make");
	}
	
	
}
