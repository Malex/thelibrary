package com.benfante.javacourse.thelibrary.business.entity;

import java.util.List;

public class RulesBIN extends GenericBIN {

	private static final long serialVersionUID = 1L;

	private List<Object> facts;

	public List<Object> getFacts() {
		return facts;
	}

	public void setFacts(List<Object> facts) {
		this.facts = facts;
	}
	
}
