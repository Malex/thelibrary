package com.benfante.javacourse.thelibrary.business;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.benfante.javacourse.thelibrary.application.model.Clerk;
import com.benfante.javacourse.thelibrary.application.model.Enumerations.ContractType;
import com.benfante.javacourse.thelibrary.application.model.Operation;
import com.benfante.javacourse.thelibrary.business.entity.Context;
import com.benfante.javacourse.thelibrary.core.model.FullName;

public class GenericAppTest {
	
	private static Context context = new Context();
	private static Clerk clerk = new Clerk();
	private static Operation op = new Operation();

	@BeforeClass
	public void setUp() {
		context.setDatetime(LocalDateTime.now());
		context.setGuid(UUID.randomUUID().toString());
		clerk.setId(555L);
		clerk.setName(new FullName("Ciccino", "Depurato"));
		clerk.setContract(ContractType.STABLE);
		clerk.setWorking(true);
		op.setClerk(clerk);
		
	}
	
	@Test
	public void test() {
	}

}
