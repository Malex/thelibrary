package com.benfante.javacourse.thelibrary.application.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.benfante.javacourse.thelibrary.application.model.Enumerations.DiscountType;
import com.benfante.javacourse.thelibrary.application.model.Enumerations.OperationType;
import com.benfante.javacourse.thelibrary.core.model.Book;

public class Operation implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Clerk clerk;
	
	private Customer customer;
	
	private OperationType operationType;
	
	private LocalDate date;
	
	/**
	 * Uguale a null se l'operazione non prevede sconti e/o prezzo
	 */
	private DiscountType discountType;
	
	private Number discount;
	
	private BigDecimal totalPrice;
	
	private List<Book> booksInOperation;

	public Clerk getClerk() {
		return clerk;
	}

	public void setClerk(Clerk clerk) {
		this.clerk = clerk;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public Number getDiscount() {
		return discount;
	}

	public void setDiscount(Number discount) {
		this.discount = discount;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Book> getBooksInOperation() {
		return booksInOperation;
	}

	public void setBooksInOperation(List<Book> booksInOperation) {
		this.booksInOperation = booksInOperation;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate dateOfOperation) {
		this.date = dateOfOperation;
	}

	public DiscountType getDiscountType() {
		return discountType;
	}

	public void setDiscountType(DiscountType discountType) {
		this.discountType = discountType;
	}
	
	
}
