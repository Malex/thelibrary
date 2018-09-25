package com.benfante.javacourse.thelibrary.business.entity;

import java.util.List;

public class RulesBOU extends GenericBOU {

	private static final long serialVersionUID = 1L;

	private List<Object> processedFacts;

	public List<Object> getProcessedFacts() {
		return processedFacts;
	}

	public void setProcessedFacts(List<Object> processedFacts) {
		this.processedFacts = processedFacts;
	}
}
