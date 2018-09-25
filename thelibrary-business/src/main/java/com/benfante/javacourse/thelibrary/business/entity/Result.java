package com.benfante.javacourse.thelibrary.business.entity;

import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Boolean result;
	
	private String code;
	
	private String message;
	
	private Boolean warning;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getWarning() {
		return warning;
	}

	public void setWarning(Boolean warning) {
		this.warning = warning;
	}
}
