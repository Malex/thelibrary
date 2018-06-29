package com.benfante.javacourse.thelibrary.core.model;

public class Author {
	
	private long id;
	private String firstName;
	private String lastName;
	
	
	public Author(long id, String firstName, String lastName) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	
	public long getId() {
		return this.id;
	}
	public void setId(long id) {
		if(id>0)
			this.id = id;
		else
			throw new IllegalArgumentException();
	}
	
	
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName!=null)
			this.firstName = firstName;
		else
			throw new IllegalArgumentException();
	}
	
	
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		if(lastName!=null)
			this.lastName = lastName;
		else
			throw new IllegalArgumentException();
	}


	
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", First Name =" + firstName + ", Last Name =" + lastName + "]";
	}
	
}
