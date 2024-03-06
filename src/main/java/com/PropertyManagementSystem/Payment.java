package com.PropertyManagementSystem;

public class Payment {
  
	private int paymentID;
	private String cNumber;
	private String name;
	private String cType;
	private String address;
	private String country;
	
	public Payment(int paymentID, String cNumber, String name, String cType, String address, String country) {
		super();
		this.paymentID = paymentID;
		this.cNumber = cNumber;
		this.name = name;
		this.cType = cType;
		this.address = address;
		this.country = country;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
