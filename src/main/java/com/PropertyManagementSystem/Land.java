package com.PropertyManagementSystem;

public class Land extends Property{
	
	private String property_name;
	private double land_area;
	private String zoning_type;
	private String land_topography;
	private String land_accessibility;
	private String potential_landuse;

	public Land(int pID, String pName, String pOwner, String pContact, String pLocation, double pAmount, String pType,int oID,
			String property_name, double land_area, String zoning_type, String land_topography, String land_accessibility, String potential_landuse) {
		
		super(pID, pName, pOwner, pContact, pLocation, pAmount, pType, oID);
		this.property_name = property_name;
		this.land_area = land_area;
		this.zoning_type = zoning_type;
		this.land_topography = land_topography;
		this.land_accessibility = land_accessibility;
		this.potential_landuse = potential_landuse;		
		
	}

	public String getProperty_name() {
		return property_name;
	}

	public double getLand_area() {
		return land_area;
	}

	public String getZoning_type() {
		return zoning_type;
	}

	public String getLand_topography() {
		return land_topography;
	}

	public String getLand_accessibility() {
		return land_accessibility;
	}

	public String getPotential_landuse() {
		return potential_landuse;
	}
	

}
