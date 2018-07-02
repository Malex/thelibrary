package com.benfante.javacourse.thelibrary.core.model;

public class Book {
	private long Id;
	private String title;
	private float price;
	private Author[] author = new Author[0];
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
		this.author = new Author[0];
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
		
		len = this.getAuthor().length;
		
		Author[] newAuthors = new Author[len+1];
		
		for(int i=0; i<len;i++)
			newAuthors[i] = this.getAuthor()[i];
		
		newAuthors[len] = author;
		
		this.author = newAuthors;
	}
	
	
	public boolean hasAuthor(Author author) {
		for(Author g : this.getAuthor()) {
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
		if(this.getPrice()!=0)
			str.append("\nPrice: ").append(this.getPrice());
		
		return  str.toString();
	}

	
	@Override
	public boolean equals(Object o) {
		Book book = (Book)o;
		if(this.getId()==book.getId()) {
			if(this.getAuthor().length!=book.getAuthor().length)
				return false;
			boolean isThere = this.getAuthor().length==0; //this way it works for 0 authors.
			for(Author g : this.getAuthor()) {
				isThere = book.hasAuthor(g);
				if(!isThere)
					break;
			}
			assert isThere && (this.getTitle().equals(book.getTitle())) && this.getPrice()==book.getPrice() && ((this.getPublisher()!=null)?(this.getPublisher().equals(book.getPublisher())):true);
			return true;
		}
		else 
			return false;
	}
	
}

