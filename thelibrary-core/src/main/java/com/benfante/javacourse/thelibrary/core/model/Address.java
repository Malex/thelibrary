package com.benfante.javacourse.thelibrary.core.model;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String addressLine1;
	private String addressLine2;
	private String postalCode;
	private String city;
	private String province;
	private String nation;
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) throws IllegalArgumentException {
		if(addressLine1!=null)
			this.addressLine1 = addressLine1;
		else 
			throw new IllegalArgumentException();
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2)  throws IllegalArgumentException {
		if(addressLine2!=null)
			this.addressLine2 = addressLine2;
		else
			throw new IllegalArgumentException();
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) throws IllegalArgumentException {
		if(postalCode!=null)
			this.postalCode = postalCode;
		else 
			throw new IllegalArgumentException();
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) throws IllegalArgumentException {
		if(city!=null)
			this.city = city;
		else
			throw new IllegalArgumentException();
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) throws IllegalArgumentException {
		if(province!=null)
			this.province = province;
		else
			throw new IllegalArgumentException();
	}
	
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) throws IllegalArgumentException {
		if(nation!=null)
			this.nation = nation;
		else
			throw new IllegalArgumentException();
	}
	
	public Address(String addressLine1, String addressLine2, String postalCode, String city, String province,
			String nation) {
		this.setAddressLine1(addressLine1);
		this.setAddressLine2(addressLine2);
		this.setPostalCode(postalCode);
		this.setCity(city);
		this.setNation(nation);
		this.setProvince(province);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((nation == null) ? 0 : nation.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (nation == null) {
			if (other.nation != null)
				return false;
		} else if (!nation.equals(other.nation))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		return true;
	}
	

	
	
}
