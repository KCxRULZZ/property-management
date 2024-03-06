package com.PropertyManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SellerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Read Method
	public static List<Property> getSellerProperty(int id){
		
		List<Property> property = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM property WHERE OID ="+id+"";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {

				int PID = rs.getInt(1);
				String pName = rs.getString(2);
				String pOwner = rs.getString(3);
				String pContact = rs.getString(4);
				String pLocation = rs.getString(5);
				Double pAmount = rs.getDouble(6);
				String pType = rs.getString(7);
				int OID = rs.getInt(8);
				
				Property p = new Property(PID,pName,pOwner,pContact,pLocation,pAmount,pType,OID);
				
				property.add(p);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return property;
		
	}
	
	
	//Insert Method
	public static boolean addProperty(String pName, String pOwner, String pContact, String pLocation, String pAmount, String pType, int OID) {
			
			boolean isSuccess = false; //return type boolean
			
			double convertAmount = Double.parseDouble(pAmount);
			
			try {
				
				con = DBConnect.getConnection(); //get connection
				stmt = con.createStatement(); //create connection
				//insert query
				String insert = "INSERT INTO property VALUES(0,'"+pName+"', '"+pOwner+"', '"+pContact+"', '"+pLocation+"', '"+convertAmount+"', '"+pType+"', '"+OID+"')";
				int rs = stmt.executeUpdate(insert);
				
				//checking if successfully inserted
				if(rs > 0) {
					isSuccess = true;
				}else {
					isSuccess = false;
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
	}
	
	//reading seller details
	public static List<User> getSeller(int id){
		
		List<User> seller = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "Select * from user where id = "+id+"";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {

				int SID = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String phone = rs.getString(4);
				String uEmail = rs.getString(5);
				String address = rs.getString(6);
				String dob = rs.getString(7);
				String uPassword = rs.getString(8);
				String type = rs.getString(9);
				
				User u = new User(SID,name,gender,phone,uEmail,address,dob,uPassword,type);
				
				//adding details to user array list
				seller.add(u);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return seller;
		
	}
	
	//Delete method when seller wants to delete an added property
	public static boolean deleteProperty(String PID) {

		int convId = Integer.parseInt(PID);

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "delete from property where PID='" + convId + "'";
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
	

}
