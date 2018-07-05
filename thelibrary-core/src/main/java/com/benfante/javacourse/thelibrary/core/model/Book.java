package com.benfante.javacourse.thelibrary.core.model;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book {
	
	private static final Logger log = LoggerFactory.getLogger(Book.class);
	
	private long Id;
	private String title;
	private BigDecimal price;
	private Author[] author = new Author[0];
	private Publisher publisher;
	private BookCategory[] categories = new BookCategory[0];;
	
	public Book(long id, String title, Author author, Publisher publisher, float price ) {
		this(id,title,author,price);
		this.setPublisher(publisher);
	}

	public Book(long Id, String title, Author author) {
		this.setId(Id);
		this.setAuthor(author);
		this.setTitle(title);
	}
	
	public Book(long Id, String title, Author author,float price) {
		this(Id,title,author);
		this.setPrice(price);
	}
	
	public Book(long id, String title, Author[] author, Publisher publisher, float price ) {
		this(id,title,author,price);
		this.setPublisher(publisher);
	}

	public Book(long Id, String title, Author[] author) {
		this.setId(Id);
		this.setAuthor(author);
		this.setTitle(title);
	}
	
	public Book(long Id, String title, Author[] author,float price) {
		this(Id,title,author);
		this.setPrice(price);
	}
	
	public long getId() {
		return this.Id;
	}
	public void setId(long id) {
		if(id>0)
			this.Id = id;
		else
			throw new IllegalArgumentException("ID must be positive");
	}
	
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		if(title!=null)
			this.title = title;
		else
			throw new IllegalArgumentException();
	}
	

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(float price) {
		if(price>=0)
			this.price = BigDecimal.valueOf(price);
		else
			throw new IllegalArgumentException("Price must be non-negative");
	}
	public void setPrice(BigDecimal price) {
		if(price.compareTo(BigDecimal.valueOf(0))>=0)
			this.price = price;
		else
			throw new IllegalArgumentException("Price must be non-negative");
	}
	
	public Author[] getAuthor() {
		return this.author;
	}
	void setAuthor(Author[] author) {
		if(author==null) 
			throw new IllegalArgumentException();
		this.author = new Author[0];
		for(Author g : author) {
			if(g.getId()<=0)
				throw new IllegalArgumentException();
			else
				this.addAuthor(g);
		}
	}
	void setAuthor(Author author) {
		if(author==null)
			throw new IllegalArgumentException();
		this.author = new Author[0];
		this.addAuthor(author);
	}
	
	public Publisher getPublisher() {
		return this.publisher;
	}
	public void setPublisher(Publisher publisher) {
		if(publisher!=null && publisher.getId() > 0)
			this.publisher = publisher;
		else
			throw new IllegalArgumentException();
	}

	
	public void addAuthor(Author author) {
		log.debug("Adding author: id={}, Name: {} {}",author.getId(),author.getFirstName(),author.getLastName());
		int len;
		if(author==null || author.getId()<=0)
			throw new IllegalArgumentException();
		
		len = this.getAuthor().length;
		
		Author[] newAuthors = new Author[len+1];
		
		for(int i=0; i<len;i++)
			newAuthors[i] = this.getAuthor()[i];
		
		newAuthors[len] = author;
		
		this.author = newAuthors;
	}
	
	
	public boolean hasAuthor(Author author) {
		if(!(author==null))
			for(Author g : this.getAuthor()) {
				if(g.hashCode()==author.hashCode())
					if(g.equals(author))
						return true;
			}
		return false;
	}
	
	public String getPrint() {
		StringBuilder str = new StringBuilder();
		str.append("ID=").append(this.getId()).append("\nTitle: ").append(this.getTitle()).append("\nAuthors: ");
		for (Author g : this.getAuthor()) {
			str.append(g.getPrint()).append("; ");
		}
		if(this.getAuthor().length==0)
			str.append("No authors for this book.; "); //Last 2 chars get deleted on next instruction
		
		str.delete(str.length()-2,str.length());
		if(this.getPublisher()!=null)
			str.append("\nPublisher: ").append(this.getPublisher().getPrint());
		if(this.getPrice().compareTo(BigDecimal.valueOf(0))!=0)
			str.append("\nPrice: ").append(this.getPrice());
		str.append("\nCategories: ");
		if(this.getCategories().length>0) {
				for(BookCategory cat : this.getCategories()) 
					str.append(cat.toString()).append(", ");
				
				str.delete(str.length()-2,str.length()).append(".");

		} else {
			str.append("No category set for this Book.");
		}
		
		return  str.toString();
	}


	public BookCategory[] getCategories() {
		return this.categories;
	}
	void setCategories(BookCategory[] categories) {
		if(categories==null)
			throw new IllegalArgumentException();
		this.categories = new BookCategory[0];
		this.addCategories(categories);
	}
	
	public void addCategory(BookCategory category) {
		int len;
		if(category==null)
			throw new IllegalArgumentException();
		
		len = this.getCategories().length;
		
		BookCategory[] newCat = new BookCategory[len+1];
		
		for(int i=0; i<len;i++) {
			if(this.getCategories()[i]==category) //avoid duplicates (probably should use a util method)
				return;
			newCat[i] = this.getCategories()[i];
		}
		newCat[len] = category;
		
		this.categories = newCat;
	}
	
	public void addCategories(BookCategory[] categories) {
		if(categories==null)
			throw new IllegalArgumentException();
		for(BookCategory cat : categories)
			this.addCategory(cat);
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(o==null || !(o instanceof Book))
			return false;
		Book book = (Book)o;
		if(this.getId()==book.getId()) {
//			if(this.getAuthor().length!=book.getAuthor().length)
//				return false;
//			boolean isThere = this.getAuthor().length==0; //this way it works for 0 authors.
//			for(Author g : this.getAuthor()) {
//				isThere = book.hasAuthor(g);
//				if(!isThere)
//					break;
//			}
//			assert isThere && (this.getTitle().equals(book.getTitle())) && this.getPrice()==book.getPrice() && ((this.getPublisher()!=null)?(this.getPublisher().equals(book.getPublisher())):true);
			return true;
		}
		else 
			return false;
	}
	
	@Override
	public int hashCode() {
//		int tmpHash = 0;
//		for(Author g : this.getAuthor())
//			tmpHash += g.hashCode();
		return Long.valueOf(this.getId()).hashCode();//+Float.valueOf(this.getPrice()).hashCode()+this.getTitle().hashCode()+((this.getPublisher()!=null)?this.getPublisher().hashCode():0)+tmpHash;
	}
	
}

