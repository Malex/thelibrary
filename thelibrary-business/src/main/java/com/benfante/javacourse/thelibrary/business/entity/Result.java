package com.benfante.javacourse.thelibrary.business.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Identify the state of the result, being true if the result is positive, false if an error occured
	 */
	private Boolean result;
	/**
	 * A unique identifier of the state of the operation. Note that only the last one is preserved, for 
	 * the others see CodeMessages
	 */
	private String code;
	/**
	 * The message relative to the state of the last operation. Note that only the last one is preserved, for 
	 * the others see CodeMessages
	 */
	private String message;
	/**
	 * It identifies whether a warning state is present. Should be null if result is false.
	 */
	private Boolean warning;
	/**
	 * A map that all codes and associated messages that occured during processing.
	 * We suggest using a map that keeps insert order, to retrieve the correct processing issues (if any)
	 * @see {@link LinkedHashMap}
	 */
	private Map<String, String> codeMessages;

	public Boolean getResult() {
		return result;
	}

	public Boolean isResult() {
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

	public Map<String, String> getCodeMessages() {
		return codeMessages;
	}

	public void setCodeMessages(Map<String, String> codeMessages) {
		this.codeMessages = codeMessages;
	}
}
