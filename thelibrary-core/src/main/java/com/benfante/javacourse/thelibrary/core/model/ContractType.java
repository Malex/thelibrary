package com.benfante.javacourse.thelibrary.core.model;

import java.io.Serializable;

public enum ContractType implements Serializable{
	STABLE("Stable"), SEASONAL("Seasonal");
	
	private String value;
	
	private ContractType(String s) {
		this.value = s;
	}
	
	@Override 
	public String toString() {
		return this.value;
	}
}
