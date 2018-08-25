package org.esudarshan.model;

import org.esudarshan.validator.IsValidCity;

public class Address {

	@IsValidCity(aValidCity = "PUNE")
	String city;
	Long pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

}
