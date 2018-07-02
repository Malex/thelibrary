package com.benfante.javacourse.thelibrary.core.model;

public class Book {
	private long Id;
	private String title;
	private float price;
	private Author[] author;
	private Publisher publisher;
	
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
	
	public long getId() {
		return this.Id;
	}
	public void setId(long id) {
		this.Id = id;
	}
	
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		if(title!=null)
			this.title = title;
	}
	

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	public Author[] getAuthor() {
		return this.author;
	}
	public void setAuthor(Author[] author) {
		for(Author g : author) {
			if(g.getId()<=0)
				throw new IllegalArgumentException();
			else
				this.addAuthor(g);
		}
	}
	public void setAuthor(Author author) {
		this.addAuthor(author);
	}
	
	public Publisher getPublisher() {
		return this.publisher;
	}
	public void setPublisher(Publisher publisher) {
		if(publisher.getId() > 0)
			this.publisher = publisher;
		else
			throw new IllegalArgumentException();
	}

	
	public void addAuthor(Author author) {
		int len;
		if(author.getId()<=0)
			throw new IllegalArgumentException();
		if(this.getAuthor()==null) {
				len = 0;
				this.author = new Author[1];
		}
		else
			len = this.getAuthor().length;
		
		Author[] newAuthors = new Author[len+1];
		
		for(int i=0; i<len;i++)
			newAuthors[i] = this.getAuthor()[i];
		
		newAuthors[len] = author;
		
		this.author = newAuthors;
	}
	
	
	public String getPrint() {
		StringBuilder str = new StringBuilder();
		str.append("ID=").append(this.getId()).append("\nTitle: ").append(this.getTitle()).append("\nAuthor: ").append(this.getAuthor());
		if(this.getPublisher()!=null)
			str.append("\nPublisher: ").append(this.getPublisher());
		if(this.getPrice()!=0)
			str.append("\nPrice: ").append(this.getPrice());
		
		return  str.toString();
	}

}

