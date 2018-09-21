package com.benfante.javacourse.thelibrary.application.model;

import java.io.Serializable;

public enum DiscountType implements Serializable {
	FULL_PRICE("Full Price"), PERCENTAGE("Percentage"), VALUE("Value");
	
	private String print;
	private DiscountType(String s) {
		this.print = s;
	}
	
	@Override
	public String toString() {
		return this.print;
	}
}
