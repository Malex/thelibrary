package com.benfante.javacourse.thelibrary.business.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Context implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String guid;
	
	private LocalDateTime datetime;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
	
}
