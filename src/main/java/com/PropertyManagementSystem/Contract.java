package com.PropertyManagementSystem;

public abstract class Contract {
	private int contractID;
    private String startDate;
    private String endDate;

    public Contract(int contractID, String startDate, String endDate) {
        this.contractID = contractID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract void generateContractDocument();

    public abstract void enforceTerms();

    public int getContractID() {
        return contractID;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
