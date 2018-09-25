package com.benfante.javacourse.thelibrary.business.utils;

import java.util.LinkedHashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benfante.javacourse.thelibrary.business.entity.Result;

public final class ResultUtils {

	private static final Logger log = LoggerFactory.getLogger(ResultUtils.class);

	private ResultUtils() {
	}

	/**
	 * Call this to have a proper instance of Result with the
	 * {@link Result#getCodeMessages()} properly inizialized
	 * 
	 * @return a {@link Result} instace (whose field are still null though, except
	 *         the map)
	 */
	public static Result inizializeResult() {
		Result res = new Result();
		res.setCodeMessages(new LinkedHashMap<String, String>());
		return res;
	}

	public static Result validateResult(final Result result) {
		if (result == null) {
			String error = "Result is null";
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		if (result.getResult() == null) {
			String error = "Result.result is null";
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		if (result.getCodeMessages() == null) {
			if (log.isInfoEnabled()) {
				log.info("Map for result is null, proceeding with inizialization");
			}
			result.setCodeMessages(new LinkedHashMap<String, String>());
		}
		return result;
	}

	/**
	 * Set the new (code,message) pair and put the old ones (if present) in the
	 * history map
	 * 
	 * @param code
	 * @param message
	 * @return the same result instance passed as parameter
	 */
	public static Result addResult(final Result result, final String code, final String message) {
		validateResult(result);
		
		if(StringUtils.isBlank(code) || StringUtils.isBlank(message)) {
			final String error = "Blank value for code and/or message not valid: code="+code+", message="+message;
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		
		if (result.getCode() != null) {
			result.getCodeMessages().put(result.getCode(), result.getMessage());
		} else if (result.getMessage() != null) {
			final String warning = "Code was null, but messagge " + result.getMessage()
					+ " was not. Message has be discarded";
			log.warn(warning);
		}
		
		result.setCode(code);
		result.setMessage(message);

		return result;
	}

	/**
	 * Creates a new result with given code and message, and positive status
	 * @param code
	 * @param message
	 * @return
	 */
	public static Result addNewResult(final String code, final String message) {
		if(StringUtils.isBlank(code) || StringUtils.isBlank(message)) {
			final String error = "Blank value for code and/or message not valid: code="+code+", message="+message;
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		
		final Result res = inizializeResult();
		res.setCode(code);
		res.setMessage(message);
		res.setResult(true);
		
		return res;
	}
	
	public static Result addWarning(final Result result,final String code, final String message) {
		validateResult(result);
		if(! result.getResult().booleanValue()) {
			String error = "Result must be positive to issue a warning";
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		addResult(result, code, message);
		result.setWarning(true);
		return result;
	}
	
	public static Result addNotPrimaryResult(final Result result, final String code, final String message) {
		validateResult(result);
		
		if(StringUtils.isBlank(code) || StringUtils.isBlank(message)) {
			final String error = "Blank value for code and/or message not valid: code="+code+", message="+message;
			log.error(error);
			throw new IllegalArgumentException(error);
		}
		
		result.getCodeMessages().put(code, message);
		
		return result;
		
	}
}
