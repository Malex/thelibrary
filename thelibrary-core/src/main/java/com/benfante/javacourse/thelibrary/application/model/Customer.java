package com.benfante.javacourse.thelibrary.application.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.benfante.javacourse.thelibrary.core.model.Address;
import com.benfante.javacourse.thelibrary.core.model.FullName;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private FullName name;
	
	private byte age;
	
	private String taxCode;
	
	private Address address;
	
	private List<Address> additionalAddresses = new LinkedList<>();

	public FullName getName() {
		return name;
	}

	public void setName(FullName name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getAdditionalAddresses() {
		return additionalAddresses;
	}

	public void setAdditionalAddresses(List<Address> additionalAddresses) {
		this.additionalAddresses = additionalAddresses;
	}
	
	

}
