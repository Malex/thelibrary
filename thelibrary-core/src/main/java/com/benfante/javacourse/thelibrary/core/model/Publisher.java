package com.benfante.javacourse.thelibrary.core.model;

public class Publisher {
	
	private long id;
	private String name;
	
	public Publisher(long id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		if(id>0)
			this.id = id;
		else
			throw new IllegalArgumentException();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name!=null)
			this.name = name;
		else
			throw new IllegalArgumentException();
	}
	
	@Override
	public boolean equals(Object o) {
		Publisher pub = (Publisher) o;
		if(this.getId()==pub.getId()) {
			if(this.getName()!=null)
				assert this.getName().equals(pub.getName());
			else 
				if(pub.getName()==null)
					return true;
			return true;
		}
		else 
			return false;
	}


	public String getPrint() {
		return this.getName();
	}
	
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", Name =" + name + "]";
	}
	
	
}
