package com.benfante.javacourse.thelibrary.core.model.utils;

import java.math.BigDecimal;
import java.util.List;

import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;
import com.benfante.javacourse.thelibrary.core.model.Publisher;

public class BookUtil {

	private BookUtil() {
	}

	public static Book generateBook(String title, Author author, Publisher publisher, BigDecimal price) {
		final Book ret = generateBook(title, author, price);
		ret.setPublisher(publisher);
		return ret;
	}

	public static Book generateBook(String title, Author author) {
		final Book ret = new Book();
		ret.setAuthor(author);
		ret.setTitle(title);
		return ret;
	}

	public static Book generateBook(String title, Author author, BigDecimal price) {
		final Book ret = generateBook(title, author);
		ret.setPrice(price);
		return ret;
	}

	public static Book generateBook(String title, Author[] author, Publisher publisher, BigDecimal price) {
		final Book ret = generateBook(title, author, price);
		ret.setPublisher(publisher);
		return ret;
	}

	public static Book generateBook(String title, Author[] author) {
		final Book ret = new Book();
		ret.setAuthor(author);
		ret.setTitle(title);
		return ret;
	}

	public static Book generateBook(String title, Author[] author, BigDecimal price) {
		final Book ret = generateBook(title, author);
		ret.setPrice(price);
		return ret;
	}

	public static Book generateBook(String title, List<Author> author, Publisher publisher, BigDecimal price) {
		final Book ret = generateBook(title, author, price);
		ret.setPublisher(publisher);
		return ret;
	}

	public static Book generateBook(String title, List<Author> author) {
		final Book ret = new Book();
		ret.setAuthor(author);
		ret.setTitle(title);
		return ret;
	}

	public static Book generateBook(String title, List<Author> author, BigDecimal price) {
		final Book ret = generateBook(title, author);
		ret.setPrice(price);
		return ret;
	}

	public static Book generateBook(String Isbn, String title, List<Author> author, Publisher publisher,
			BigDecimal price) {
		final Book ret = generateBook(title, author, publisher, price);
		ret.setIsbn(Isbn);
		return ret;
	}

	public static Book generateBook(String Isbn, String title, List<Author> author) {
		final Book ret = generateBook(title, author);
		ret.setIsbn(Isbn);
		return ret;
	}

	public static Book generateBook(String Isbn, String title, Author author) {
		final Book ret = generateBook(title, author);
		ret.setIsbn(Isbn);
		return ret;
	}

	public static Book generateBook(String Isbn, String title, List<Author> author, BigDecimal price) {
		final Book ret = generateBook(title, author, price);
		ret.setIsbn(Isbn);
		return ret;
	}

	public static Book generateBook(String Isbn, String title, Author author, Publisher pub, BigDecimal price) {
		final Book ret = generateBook(title, author, price);
		ret.setIsbn(Isbn);
		ret.setPublisher(pub);
		return ret;
	}

	public static Book generateBook(long id, String title, Author author, Publisher publisher, BigDecimal price) {
		final Book ret = generateBook(id, title, author, price);
		ret.setPublisher(publisher);
		return ret;
	}

	public static Book generateBook(long Id, String title, Author author) {
		final Book ret = new Book();
		ret.setId(Id);
		ret.setAuthor(author);
		ret.setTitle(title);
		return ret;
	}

	public static Book generateBook(long Id, String title, Author author, BigDecimal price) {
		final Book ret = generateBook(Id, title, author);
		ret.setPrice(price);
		return ret;
	}

	public static Book generateBook(long id, String title, Author[] author, Publisher publisher, BigDecimal price) {
		final Book ret = generateBook(id, title, author, price);
		ret.setPublisher(publisher);
		return ret;
	}

	public static Book generateBook(long Id, String title, Author[] author) {
		final Book ret = new Book();
		ret.setId(Id);
		ret.setAuthor(author);
		ret.setTitle(title);
		return ret;
	}

	public static Book generateBook(long Id, String title, Author[] author, BigDecimal price) {
		final Book ret = generateBook(Id, title, author);
		ret.setPrice(price);
		return ret;
	}

	public static Book generateBook(long id, String title, List<Author> author, Publisher publisher, BigDecimal price) {
		final Book ret = generateBook(id, title, author, price);
		ret.setPublisher(publisher);
		return ret;
	}

	public static Book generateBook(long Id, String title, List<Author> author) {
		final Book ret = new Book();
		ret.setId(Id);
		ret.setAuthor(author);
		ret.setTitle(title);
		return ret;
	}

	public static Book generateBook(long Id, String title, List<Author> author, BigDecimal price) {
		final Book ret = generateBook(Id, title, author);
		ret.setPrice(price);
		return ret;
	}

	public static Book generateBook(long id, String Isbn, String title, List<Author> author, Publisher publisher,
			BigDecimal price) {
		final Book ret = generateBook(id, title, author, publisher, price);
		ret.setIsbn(Isbn);
		return ret;
	}

	public static Book generateBook(long Id, String Isbn, String title, List<Author> author) {
		final Book ret = generateBook(Id, title, author);
		ret.setIsbn(Isbn);
		return ret;
	}

	public static Book generateBook(long Id, String Isbn, String title, List<Author> author, BigDecimal price) {
		final Book ret = generateBook(Id, title, author, price);
		ret.setIsbn(Isbn);
		return ret;
	}

}
