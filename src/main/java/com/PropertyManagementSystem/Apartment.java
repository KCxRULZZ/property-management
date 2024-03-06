package com.PropertyManagementSystem;

public class Apartment extends Property{
	
	private String property_name;
	private int num_bedrooms;
	private int num_bathrooms;
	private int floor_number;
	private String has_balcony;
	private String building_amenities;

	public Apartment(int pID, String pName, String pOwner, String pContact, String pLocation, double pAmount,String pType, int oID, 
			String property_name, int num_bedrooms, int num_bathrooms, int floor_number, String has_balcony, String building_amenities) {

		super(pID, pName, pOwner, pContact, pLocation, pAmount, pType, oID);
		this.property_name = property_name;
		this.num_bedrooms = num_bedrooms;
		this.num_bathrooms = num_bathrooms;
		this.floor_number = floor_number;
		this.has_balcony = has_balcony;
		this.building_amenities = building_amenities;

	}

	public String getProperty_name() {
		return property_name;
	}

	public int getNum_bedrooms() {
		return num_bedrooms;
	}

	public int getNum_bathrooms() {
		return num_bathrooms;
	}
	
	public int getFloor_number() {
		return floor_number;
	}

	public String getHas_balcony() {
		return has_balcony;
	}

	public String getBuilding_amenities() {
		return building_amenities;
	}

	
	

}
