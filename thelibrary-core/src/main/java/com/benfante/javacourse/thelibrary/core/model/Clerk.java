package com.benfante.javacourse.thelibrary.core.model;

public class Clerk {
	private Long id;
	private FullName name;
	private boolean working;
	private ContractType contract;
	
	public Clerk(Long id,String firstName,String lastName, ContractType contract) {
		this.id = id;
		this.name = new FullName(firstName, lastName);
		this.contract = contract;
	}
	
	public Long getId() {
		return this.id;
	}
	
	
	public FullName getFullName() {
		return this.name;
	}
	
	public boolean isWorking() {
		return this.working;
	}
	
	
	
	
}
