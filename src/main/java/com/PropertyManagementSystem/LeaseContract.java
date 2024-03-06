package com.PropertyManagementSystem;

public class LeaseContract extends Contract {
	 	private String tenantName;
	    private double monthlyRent;

	    public LeaseContract(int contractID, String startDate, String endDate, String tenantName, double monthlyRent) {
	        super(contractID, startDate, endDate);
	        this.tenantName = tenantName;
	        this.monthlyRent = monthlyRent;
	    }

	    @Override
	    public void generateContractDocument() {
	        System.out.println("Generating Lease Contract Document...");
	    }

	    @Override
	    public void enforceTerms() {
	        System.out.println("Enforcing Lease Contract Terms...");
	    }
}
