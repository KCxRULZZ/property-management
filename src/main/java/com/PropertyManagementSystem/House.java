package com.PropertyManagementSystem;

public class House extends Property{

	private String property_name;
	private int num_bedrooms;
	private int num_bathrooms;
	private double square_footage;
	private String has_garage;
	private String house_amenities;
	
	public House() {
		super();
	}
	
	public House(int pID, String pName, String pOwner, String pContact, String pLocation, double pAmount, String pType,int oID, 
			String property_name,int num_bedrooms, int num_bathrooms, double square_footage, String has_garage,String house_amenities) {

		super(pID, pName, pOwner, pContact, pLocation, pAmount, pType, oID);
		this.property_name = property_name;
		this.num_bedrooms = num_bedrooms;
		this.num_bathrooms = num_bathrooms;
		this.square_footage = square_footage;
		this.has_garage = has_garage;
		this.house_amenities = house_amenities;
	}
	
	public void addPropertyType(String property_name,int num_bedrooms, int num_bathrooms, double square_footage, String has_garage,String house_amenities) {
		this.property_name = property_name;
		this.num_bedrooms = num_bedrooms;
		this.num_bathrooms = num_bathrooms;
		this.square_footage = square_footage;
		this.has_garage = has_garage;
		this.house_amenities = house_amenities;
	}

	public String getproperty_name() {
		return property_name;
	}

	public int getNum_bedrooms() {
		return num_bedrooms;
	}

	public int getNum_bathrooms() {
		return num_bathrooms;
	}

	public double getSquare_footage() {
		return square_footage;
	}

	public String getHas_garage() {
		return has_garage;
	}

	public String getHouse_amenities() {
		return house_amenities;
	}


}
