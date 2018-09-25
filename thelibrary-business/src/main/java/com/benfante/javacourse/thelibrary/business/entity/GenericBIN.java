package com.benfante.javacourse.thelibrary.business.entity;

import java.io.Serializable;

public class GenericBIN implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Context context;

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

}
