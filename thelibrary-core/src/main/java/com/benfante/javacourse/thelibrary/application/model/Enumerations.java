package com.benfante.javacourse.thelibrary.application.model;

import java.io.Serializable;

public class Enumerations {
	
	public enum OperationType {
		BUY, SELL, BORROW, LEND, GIVEBACK
	};
	
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
	};
	
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
	};
}
