package com.benfante.javacourse.thelibrary.core.util;

import com.benfante.javacourse.thelibrary.core.model.Author;

public class AuthorUtil {
	
	private AuthorUtil() {}
	
	public static String getString(Author auth) {
		return auth.getFirstName()+" "+auth.getLastName();
	}

	public static String toString(Author auth) {
		StringBuilder sb = new StringBuilder();
		sb.append("Author [ id=");
		sb.append(auth.getId()).append(", name=\"");
		sb.append(auth.getFirstName()).append(" ").append(auth.getLastName()).append("\"");
		return sb.toString();
	}
}
