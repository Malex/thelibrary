package com.benfante.javacourse.thelibrary.core.dao.serialization;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class SerializationStorage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(SerializationStorage.class);
	private String archive;

	
	Collection<Book> books = new HashSet<>();

	Map<String,Collection<Book>> booksByTitle = new HashMap<>(); 
	Map<Author,Collection<Book>> booksByAuthor = new HashMap<>();
	Map<String,Book> booksByIsbn = new HashMap<>(); 

	public SerializationStorage(InputStream input) throws IOException, ClassNotFoundException {
		this.loadArchive(input);
	}

	public SerializationStorage(String filesource) throws ClassNotFoundException, FileNotFoundException, IOException {
		this.archive = filesource;	
		this.loadArchive(this.archive);
	}

	public SerializationStorage() {
		this.archive="";
	}
	
	@SuppressWarnings("unchecked")
	protected void loadArchive(InputStream input) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(input));
		this.addBooks((HashSet<Book>) in.readObject());
	}
	
	private void loadArchive(String fileSource) throws ClassNotFoundException, FileNotFoundException, IOException {
		File file = new File(fileSource);
		log.info("Loading books from {} file",file.getAbsolutePath());
		if(file.exists()) {
			try(InputStream fis = new FileInputStream(file)) {
				this.loadArchive(fis);
			}
		}
	}
	
	void storeArchive() throws FileNotFoundException, IOException {
		try(OutputStream fos = new FileOutputStream(this.archive);) {
			this.storeArchive(fos);
		}
	}
	
	private void storeArchive(OutputStream os) {
		try(ObjectOutputStream oj = new ObjectOutputStream(new BufferedOutputStream(os));) {
			log.info("Saving into {}",oj.toString());
			oj.writeObject(this.books);
		} catch(IOException e) {
			log.error("Couldnt create output .dat archive");
			e.printStackTrace();

		}
	}
	
	void addBooks(Book[] books) {
		for (Book g : books)
			this.addBook(g); 
	}
	void addBooks(Collection<Book> books){
		for (Book g : books)
			this.addBook(g); 
	}
	void addBook(Book book) {
//		Book[] new_books = new Book[this.books.length+1];
//		for(int i=0; i<this.books.length; i++)
//			new_books[i]=this.books[i];
//		new_books[this.books.length] = book;
//		this.books = new_books;
		this.books.add(book);
		this.updateMaps(book);
//		this.storeArchive();
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
	void removeBook(Book book) {
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
//		this.storeArchive();
	}
	
	void removeBooks(Book[] books) {
		for(Book b : books)
			this.removeBook(b);
	}
	void removeBooks(Collection<Book> books) {
		for(Book b : books) {
			this.removeBook(b);
		}
	}
	
}
