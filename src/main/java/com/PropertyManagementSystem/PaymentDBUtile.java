package com.PropertyManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PaymentDBUtile {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List<Payment> getAllPayment(){
		
		List<Payment> payment = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM payment";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int paymentID = rs.getInt(1);
				String cNumber = rs.getString(2);
				String name = rs.getString(3);
				String cType = rs.getString(4);
				String address = rs.getString(5);
				String country = rs.getString(6);
				
				Payment p = new Payment(paymentID,cNumber,name,cType,address,country);
				
				payment.add(p);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return payment;
		
	}
	

	// payment data send to DB path

	public static boolean PaymentSend(String Cnumber, String name, String Ctype, String address, String Country) {

		boolean isSuccess = false;

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			// insert query
			String insert = "INSERT INTO Payment VALUES(0,'" + Cnumber + "','" + name + "','" + Ctype + "','" + address
					+ "','" + Country + "')";
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

	//payment update section
	
	public static boolean updatePayment(String id,String Cnumber,String name,String Ctype,String address,String Country) 
	{

		boolean isSucess = false;
		try {
			con =DBConnect.getConnection();
			stmt =con.createStatement();
			String sql = "UPDATE Payment SET Cnumber = '" + Cnumber + "', name = '" + name + "', Ctype = '" + Ctype + "', address = '" + address + "', Country = '" + Country + "' WHERE PaymentID = '" + id + "'";
			
			int rs=stmt.executeUpdate(sql);
			if(rs>0) {
				isSucess=true;
		}
			else {
				isSucess= false;
			}
		
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	

       return isSucess;
}
	
	//Delete payment section
	public static boolean deletePayment(String id) {
		boolean isSucess = false;
		int convID =Integer.parseInt(id);
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql="delete from payment where PaymentID ='"+convID+"'";
			
			
			int rs=stmt.executeUpdate(sql);
			if(rs>0) {
				isSucess=true;
		}
			else {
				isSucess= false;
			}
		
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		return isSucess;
	}
	
	
}

