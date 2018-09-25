package com.benfante.javacourse.thelibrary.business.entity;

import java.io.Serializable;

public class GenericBOU implements Serializable {

	private static final long serialVersionUID = 1L;

	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

}
