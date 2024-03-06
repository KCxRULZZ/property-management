package com.PropertyManagementSystem;

public class Bookmark {
	
	private int bookID;
	private int PID;
	private int BID;
	private String pName;
	private String pOwner;
	private double pAmount;
	private String pAddress;
	private String oContact;
	
	public Bookmark() {
		
	}
	
	public Bookmark(int bookID, int pID, int bID, String pName, String pOwner, double pAmount, String pAddress, String oContact) {
		super();
		this.bookID = bookID;
		PID = pID;
		BID = bID;
		this.pName = pName;
		this.pOwner = pOwner;
		this.pAmount = pAmount;
		this.pAddress = pAddress;
		this.oContact = oContact;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpOwner() {
		return pOwner;
	}

	public void setpOwner(String pOwner) {
		this.pOwner = pOwner;
	}

	public double getpAmount() {
		return pAmount;
	}

	public void setpAmount(double pAmount) {
		this.pAmount = pAmount;
	}

	public String getpAddress() {
		return pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	public String getoContact() {
		return oContact;
	}

	public void setoContact(String oContact) {
		this.oContact = oContact;
	}
	
	
	
	

}
