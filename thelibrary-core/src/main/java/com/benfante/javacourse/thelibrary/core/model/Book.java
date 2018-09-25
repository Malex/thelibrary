package com.benfante.javacourse.thelibrary.core.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "book", uniqueConstraints = @UniqueConstraint(columnNames = { "isbn" }))
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(Book.class);

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Basic(optional = false)
	@Column(unique = true, nullable = false)
	private String isbn;
	@Column(nullable = false)
	private String title;
	private BigDecimal price;
	// (cascade= {CascadeType.MERGE, CascadeType.PERSIST}) /// problem in the
	// future?
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Author> author = new ArrayList<>();
	@ManyToOne(cascade = { CascadeType.ALL })
	private Publisher publisher;
	@ElementCollection(targetClass = BookCategory.class, fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	@OrderBy("category ASC")
	private SortedSet<BookCategory> categories = new TreeSet<>();

	public Book() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = BigDecimal.valueOf(price);
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Author> getAuthor() {
		return this.author;
	}

	public void setAuthor(Author[] author) {
		this.author.clear();
		for (Author g : author) {
			this.addAuthor(g);
		}
	}

	public void setAuthor(Author author) {
		this.author.clear();
		this.addAuthor(author);
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
			this.publisher = publisher;
	}

	public void addAuthor(Author author) throws RuntimeException {
		if(log.isDebugEnabled()) {
			log.debug("Adding author: id={}, Name: {} {}", author.getId(), author.getFirstName(), author.getLastName());
		}
		if (!this.author.add(author)) // adding happens here
			throw new RuntimeException("Could not add author");
	}

	public boolean hasAuthor(Author author) {
		return this.getAuthor().contains(author);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("ID=").append((this.getId() != null) ? this.getId() : "null").append("\nISBN: ")
				.append(this.getIsbn()).append("\nTitle: ").append(this.getTitle()).append("\nAuthors: ");
		for (Author g : this.getAuthor()) {
			str.append(g.toString()).append("; ");
		}
		if (this.getAuthor().isEmpty())
			str.append("No authors for this book.; "); // Last 2 chars get deleted on next instruction

		str.delete(str.length() - 2, str.length());
		if (this.getPublisher() != null)
			str.append("\nPublisher: ").append(this.getPublisher().getPrint());
		if (this.getPrice().compareTo(BigDecimal.valueOf(0)) != 0)
			str.append("\nPrice: ").append(this.getPrice());
		str.append("\nCategories: ");
		if (this.getCategories().size() > 0) {
			for (BookCategory cat : this.getCategories())
				str.append(cat.toString()).append(", ");

			str.delete(str.length() - 2, str.length()).append(".");

		} else {
			str.append("No category set for this Book.");
		}

		return str.toString();
	}

	public SortedSet<BookCategory> getCategories() {
		return this.categories;
	}

	void setCategories(BookCategory[] categories) {
		this.categories.clear();
		this.addCategories(categories);
	}

	void setCategories(Set<BookCategory> categories) {
		this.categories.clear();
		this.addCategories(categories);
	}

	public void addCategory(BookCategory category) {
		// int len;
		this.categories.add(category);
		// len = this.getCategories().length;
		//
		// BookCategory[] newCat = BookUtil.generateBookCategory[len+1];
		//
		// for(int i=0; i<len;i++) {
		// if(this.getCategories()[i]==category) //avoid duplicates (probably should use
		// a util method)
		// return;
		// newCat[i] = this.getCategories()[i];
		// }
		// newCat[len] = category;
		//
		// this.categories = newCat;
	}

	public void addCategories(BookCategory[] categories) {
		for (BookCategory cat : categories)
			this.addCategory(cat);
	}

	public void addCategories(Set<BookCategory> categories) {
		for (BookCategory cat : categories)
			this.addCategory(cat);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Book))
			return false;
		Book book = (Book) o;
		if (this.getIsbn().equals(book.getIsbn())) {
			return true;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return this.getIsbn().hashCode();
	}

}
