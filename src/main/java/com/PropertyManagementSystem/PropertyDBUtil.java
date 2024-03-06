package com.PropertyManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class PropertyDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Read Method
	public static List<Property> getAllProperties() {
        List<Property> properties = new ArrayList<>();

        try {
        	con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM property";
			rs = stmt.executeQuery(sql);

            while (rs.next()) {
            	
            	int PID = rs.getInt(1);
            	String pName = rs.getString(2);
            	String pOwner = rs.getString(3);
            	String pContact = rs.getString(4);
            	String pLocation = rs.getString(5);
            	double pAmount = rs.getDouble(6);
            	String pType = rs.getString(7);
            	int OID = rs.getInt(8);
            	
            	Property p = new Property(PID,pName,pOwner,pContact,pLocation,pAmount,pType,OID);
            	
            	properties.add(p);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return properties;
    }
	
	//Property delete method when seller profile is deleted
	public static boolean deleteProperty(String OID) {

		int convId = Integer.parseInt(OID);

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "delete from property where OID='" + convId + "'";
			int r = stmt.executeUpdate(sql);

			if (r > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	//Update Method
	public static boolean updateProperty(String PID, String pName, String pOwner, String pContact, String pLocation, String pAmount,
			String property_type, int OID) {

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			int convertPID = Integer.parseInt(PID);
			double convertAmount = Double.parseDouble(pAmount);

			String update = "Update property set pName = '" + pName + "', pOwner = '" + pOwner + "', pContact = '"
					+ pContact + "', pLocation = '" + pLocation + "', " + "pAmount = '" + convertAmount + "', pType = '"
					+ property_type + "' WHERE PID = '" + convertPID + "' AND OID = '" + OID + "' ";
			int rs = stmt.executeUpdate(update);

			// checking if successfully updated
			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	//House Insert Method
	public static boolean addHouse(String property_name,int num_bedrooms,int num_bathrooms,double square_footage,String has_garage,String house_amenities) {

		boolean isSuccess = false;

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			// insert query
			String insert = "INSERT INTO house VALUES('"+property_name+"', '"+num_bedrooms+"', '"+num_bathrooms+"', "
					+ "'"+square_footage+"', '"+has_garage+"', '"+house_amenities+"')";
			int rs = stmt.executeUpdate(insert);

			// checking if successfully inserted
			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	// Apartment Insert Method
	public static boolean addApartment(String property_name, int num_bedrooms, int num_bathrooms, int floor_number,
			String has_balcony, String building_amenities) {

		boolean isSuccess = false;

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			// insert query
			String insert = "INSERT INTO apartment VALUES('"+property_name+"', '"+num_bedrooms+"', '"+num_bathrooms+"', "
					+ "'"+floor_number+"', '"+has_balcony+"', '"+building_amenities+"')";
			int rs = stmt.executeUpdate(insert);

			// checking if successfully inserted
			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	// Land Insert Method
		public static boolean addLand(String property_name, double land_area, String zoning_type, String land_topography,
				String land_accessibility, String potential_landuse) {

			boolean isSuccess = false;

			try {

				con = DBConnect.getConnection();
				stmt = con.createStatement();
				// insert query
				String insert = "INSERT INTO land VALUES('" + property_name + "', '" + land_area + "', '" + zoning_type
						+ "', '" + land_topography + "', '" + land_accessibility + "', '" + potential_landuse + "')";
				int rs = stmt.executeUpdate(insert);

				// checking if successfully inserted
				if (rs > 0) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return isSuccess;
		}
	
	//Read all House Details
	public static List<House> getAllHouses() {
		List<House> house = new ArrayList<>();

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "SELECT * FROM house";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String property_name = rs.getString(1);
				int num_bedrooms = rs.getInt(2);
				int num_bathrooms = rs.getInt(3);
				double square_footage = rs.getDouble(4);
				String has_garage = rs.getString(5);
				String house_amenities = rs.getString(6);
				
				House h = new House();
				
				h.addPropertyType(property_name, num_bedrooms, num_bathrooms, square_footage, has_garage, house_amenities);

				house.add(h);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return house;
	}


}
