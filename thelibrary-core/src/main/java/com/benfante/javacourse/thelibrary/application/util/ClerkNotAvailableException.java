package com.benfante.javacourse.thelibrary.application.util;

import java.time.LocalDate;

import com.benfante.javacourse.thelibrary.application.model.Clerk;

public class ClerkNotAvailableException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private LocalDate operationDate = LocalDate.now();

	private Clerk clerk;

	public ClerkNotAvailableException(String message, Throwable cause, Clerk clerk, LocalDate date) {
		super(message, cause);
		this.clerk = clerk;
		if (date != null) {
			this.operationDate = date;
		}
	}

	public ClerkNotAvailableException(Clerk clerk, LocalDate date) {
		super();
		this.clerk = clerk;
		if (date != null) {
			this.operationDate = date;
		}
	}

	public ClerkNotAvailableException(String message, Clerk clerk, LocalDate date) {
		super(message);
		this.clerk = clerk;
		if (date != null) {
			this.operationDate = date;
		}
	}

	public ClerkNotAvailableException(Throwable cause, Clerk clerk, LocalDate date) {
		super(cause);
		this.clerk = clerk;
		if (date != null) {
			this.operationDate = date;
		}
	}
}
