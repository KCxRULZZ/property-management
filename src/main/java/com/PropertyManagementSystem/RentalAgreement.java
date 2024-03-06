package com.PropertyManagementSystem;

public class RentalAgreement extends Contract {
	private String renterName;
    private double dailyRate;

    public RentalAgreement(int contractID, String startDate, String endDate, String renterName, double dailyRate) {
        super(contractID, startDate, endDate);
        this.renterName = renterName;
        this.dailyRate = dailyRate;
    }

    @Override
    public void generateContractDocument() {
        System.out.println("Generating Rental Agreement Document...");
    }

    @Override
    public void enforceTerms() {
        System.out.println("Enforcing Rental Agreement Terms...");
    }
}
