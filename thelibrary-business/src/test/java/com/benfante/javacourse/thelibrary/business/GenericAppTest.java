package com.benfante.javacourse.thelibrary.business;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.builder.ReleaseId;

import com.benfante.javacourse.thelibrary.application.model.Clerk;
import com.benfante.javacourse.thelibrary.application.model.Enumerations.ContractType;
import com.benfante.javacourse.thelibrary.application.model.Operation;
import com.benfante.javacourse.thelibrary.business.entity.Context;
import com.benfante.javacourse.thelibrary.core.model.Author;
import com.benfante.javacourse.thelibrary.core.model.Book;
import com.benfante.javacourse.thelibrary.core.model.FullName;
import com.benfante.javacourse.thelibrary.core.model.Publisher;
import com.benfante.javacourse.thelibrary.core.model.utils.BookUtil;

public class GenericAppTest {
	
	private static Context context = new Context();
	private static Clerk clerk = new Clerk();
	private static Operation op = new Operation();

	@BeforeClass
	public static void setUp() {
		ReleaseId ss = null;
		context.setDatetime(LocalDateTime.now());
		context.setGuid(UUID.randomUUID().toString());
		clerk.setId(555L);
		clerk.setName(new FullName("Ciccino", "Depurato"));
		clerk.setContract(ContractType.STABLE);
		clerk.setWorking(true);
		op.setClerk(clerk);
		
		Long id = 1L;
		String title = "A title";
		Author author = new Author(1, "The", "single author");
		Publisher publisher = new Publisher(1, "A publisher");
		float price = 1.23f;
		Book book = BookUtil.generateBook(id, title, author, publisher, BigDecimal.valueOf(price));
		
		String newTitle = "Another title";
		Author newAuthor = new Author(2, "Another", "author");
		Publisher newPublisher = new Publisher(2, "Another publisher");
		float newPrice = 2.34f;
		Book book2 = BookUtil.generateBook(3L, newTitle, newAuthor, newPublisher, BigDecimal.valueOf(newPrice));
		
		List<Book> lb = new LinkedList<Book>();
		lb.add(book); lb.add(book2);
		
		op.setBooksInOperation(lb);
		
		
		
	}
	
	@Test
	public void test() {
	}

}
