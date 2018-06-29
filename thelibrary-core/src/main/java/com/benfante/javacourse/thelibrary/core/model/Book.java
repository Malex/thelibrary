package com.benfante.javacourse.thelibrary.core.model;

public class Book {
	private long Id;
	private String title;
	private float price;
	private String author;
	
	public Book(long Id, String title, String author) {
		this.setId(Id);
		this.setAuthor(author);
		this.setTitle(title);
	}
	
	public Book(long Id, String title, String author,float price) {
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
	
	
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		if(author!=null)
		this.author = author;
	}

	public String getPrint() {
		StringBuilder str = new StringBuilder();
		str.append("ID=").append(this.getId()).append("\nTitle: ").append(this.getTitle()).append("\nAuthor: ").append(this.getAuthor());
		if(this.getPrice()!=0)
			str.append("\nPrice: ").append(this.getPrice());
		
		return  str.toString();
	}

}

