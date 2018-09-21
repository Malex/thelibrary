package com.benfante.javacourse.thelibrary.application.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.benfante.javacourse.thelibrary.core.model.FullName;

@Entity
public class Clerk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(unique=true)
	@Column(nullable=false)
	private FullName name;
	@Column(nullable=false)
	private Boolean working;
	@Enumerated(EnumType.STRING)
	private ContractType contract;

	public Clerk() {
	}
	
	public Clerk(Long id, String firstName, String lastName, ContractType contract) {
		this.id = id;
		this.name = new FullName(firstName, lastName);
		this.contract = contract;
	}

	public Long getId() {
		return this.id;
	}

	public FullName getName() {
		return this.name;
	}

	public boolean isWorking() {
		return this.working;
	}

	public void setName(FullName name) {
		this.name = name;
	}

	public ContractType getContract() {
		return contract;
	}

	public void setContract(ContractType contract) {
		this.contract = contract;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

}
