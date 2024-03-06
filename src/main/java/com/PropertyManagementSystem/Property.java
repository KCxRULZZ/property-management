package com.PropertyManagementSystem;

public class Property {
	
	protected int PID;
	protected String pName;
	protected String pOwner;
	protected String pContact;
	protected String pLocation;
	protected double pAmount;
	protected String pType;
	protected int OID;	
	
	public Property() {
		
	}
	
	public Property(int pID, String pName, String pOwner, String pContact, String pLocation, double pAmount,
			String pType, int oID) {
		PID = pID;
		this.pName = pName;
		this.pOwner = pOwner;
		this.pContact = pContact;
		this.pLocation = pLocation;
		this.pAmount = pAmount;
		this.pType = pType;
		OID = oID;
	}

	public int getPID() {
		return PID;
	}

	public String getpName() {
		return pName;
	}

	public String getpOwner() {
		return pOwner;
	}
	
	public String getpContact() {
		return pContact;
	}

	public String getpLocation() {
		return pLocation;
	}

	public double getpAmount() {
		return pAmount;
	}

	public String getpType() {
		return pType;
	}

	public int getOID() {
		return OID;
	}

}
