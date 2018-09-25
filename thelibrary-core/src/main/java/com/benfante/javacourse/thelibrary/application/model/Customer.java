package com.benfante.javacourse.thelibrary.application.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.benfante.javacourse.thelibrary.core.model.Address;
import com.benfante.javacourse.thelibrary.core.model.FullName;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@OneToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(unique=true)
	@Column(nullable=false)
	private FullName name;
	
	
	private Byte age;
	
	@Column(length=16, nullable=false)
	private String taxCode;
	
	@Embedded
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
