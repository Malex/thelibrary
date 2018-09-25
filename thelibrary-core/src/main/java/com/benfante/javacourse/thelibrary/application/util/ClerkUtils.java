package com.benfante.javacourse.thelibrary.application.util;

import java.io.IOException;
import java.util.Properties;
import java.time.*;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benfante.javacourse.thelibrary.application.model.Clerk;
import com.benfante.javacourse.thelibrary.application.model.Enumerations.ContractType;

public class ClerkUtils {
	
	private static final Logger log = LoggerFactory.getLogger(ClerkUtils.class);

	private ClerkUtils() {
	}
	
	public static boolean isAvailable(Clerk clerk, LocalDate now) {
		if(clerk==null) {
			throw new IllegalArgumentException("Il parametro Clerk deve essere valorizzato");
		}
		if(ContractType.STABLE.equals(clerk.getContract())) {
			return true;
		} else if(ContractType.SEASONAL.equals(clerk.getContract())) {
			Properties prop = new Properties();
			try {
				prop.load(ClerkUtils.class.getResourceAsStream("/contracts.properties"));
				String start = prop.getProperty("Seasonal.StartingDate");
				String end = prop.getProperty("Seasonal.StartingDate");
				if(StringUtils.isBlank(start)||StringUtils.isBlank(end)) {
					String error = "Blank value of properties in contracts.properties";
					log.error(error);
					throw new RuntimeException(error);
				}
				LocalDate startDate = LocalDate.parse(start);
				LocalDate endDate = LocalDate.parse(end);
				if(now==null) {
					now = LocalDate.now();
				}
				if(now.isAfter(startDate) && now.isBefore(endDate)) {
					return true;
				} else {
					return false;
				}
			} catch (IOException e) {
				String error = "Could not locate properties file to asses valid Seasonal period for contract";
				log.error(error);
				throw new RuntimeException(error);
			} catch (DateTimeParseException e) {
				String error = "Could not parse value of date properties for seasonal contract";
				log.error(error);
				throw new ClerkNotAvailableException(error,clerk,now);
			}
		}
		log.warn("Il contratto del Clerk [id="+clerk.getId()+", nome="+clerk.getName()+" non è stato valorizzato");
		return false;
	}

}
