package com.benfante.javacourse.thelibrary.core.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Author implements Serializable,Comparable<Author> {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private FullName name;
	
	
	public FullName getFullName() {
		return name;
	}

	public Author() {}
	
	public Author(FullName name) {
		this.name = name;
	}
	
	public Author(long id, String firstName, String lastName) {
		this.setId(id);
		this.name = new FullName(firstName,lastName);
	}
	
	
	public Author(String firstName, String lastName) {
		this(new FullName(firstName,lastName));
	}

	public Long getId() {
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
		if(this.getFirstName().equals(author.getFirstName()) && this.getLastName().equals(author.getLastName())) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.getFirstName().hashCode()+this.getLastName().hashCode();
	}
	
	@Override
	public String toString() {
		return "Author [id=" + this.getId() + ", name= "+this.name.toString()+" ]";
	}
	
	public String getPrint() {
		return this.getFirstName()+" "+this.getLastName();
	}


	@Override
	public int compareTo(Author o) {
		if(o.getId()==this.getId()) //NullPointerException is automatically raised here
			return 0;
		else 
			return (this.getId()<o.getId())?-1:1;
	}
	
}
