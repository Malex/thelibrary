package com.benfante.javacourse.thelibrary.core.model;

import java.io.Serializable;

public class Author implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private FullName name;
	
	
	public Author(long id, String firstName, String lastName) {
		this.setId(id);
		this.name = new FullName(firstName,lastName);
	}
	
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		if(id>=0)
			this.id = id;
		else
			throw new IllegalArgumentException();
	}
	
	
	public String getFirstName() {
		return this.name.getFirstName();
	}
	public void setFirstName(String firstName) {
		if(firstName!=null)
			this.name.setFirstName(firstName);
		else
			throw new IllegalArgumentException();
	}
	
	
	public String getLastName() {
		return this.name.getLastName();
	}
	public void setLastName(String lastName) {
		if(lastName!=null)
			this.name.setLastName(lastName);
		else
			throw new IllegalArgumentException();
	}
	
	
	public boolean isAuthor(Book book) {
		for(Author g : book.getAuthor())
			if(g.hashCode()==this.hashCode())
				if(g.equals(this))
					return true;
			else
				continue;
		return false;
	}
	

	@Override
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o instanceof Author))
			return false;
		Author author = (Author) o;
		if(this.getId()==author.getId()) {
			//assert this.getFirstName().equals(author.getFirstName()) && this.getLastName().equals(author.getLastName());
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Long.valueOf(this.getId()).hashCode();//+this.getFirstName().hashCode()+this.getLastName().hashCode();
	}
	
	@Override
	public String toString() {
		return "Author [id=" + this.getId() + ", name= "+this.name.toString()+" ]";
	}
	
	public String getPrint() {
		return this.getFirstName()+" "+this.getLastName();
	}
	
}
