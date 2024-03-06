package com.PropertyManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.mysql.jdbc.PreparedStatement;

public class UserDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//Validate Method
	public static List<User> validate(String email, String password){
		
		//create user array list to save and return user details
		ArrayList<User> user = new ArrayList<>();
		
		//validate user
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * FROM user WHERE email = '"+email+"' and password = '"+password+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String phone = rs.getString(4);
				String uEmail = rs.getString(5);
				String address = rs.getString(6);
				String dob = rs.getString(7);
				String uPassword = rs.getString(8);
				String type = rs.getString(9);
				
				User u = new User(id,name,gender,phone,uEmail,address,dob,uPassword,type);
				
				//adding details to user array list
				user.add(u);
			}else {
				
				return null;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//returning user array list details
		return user;
		
	}
	
	//Insert Method
	public static boolean registerUser(String name, String gender, String phone, String email, String address, String dob, String password, String uType ) {
		
		boolean isSuccess = false;
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			//insert query
			String insert = "INSERT INTO user VALUES(0,'"+name+"','"+gender+"','"+phone+"','"+email+"','"+address+"','"+dob+"','"+password+"','"+uType+"')";
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
	
	//Buyer Read Method
	public static List<User> getAllBuyers(){
		
		List<User> buyer = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM user WHERE type = 'Buyer'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String phone = rs.getString(4);
				String uEmail = rs.getString(5);
				String address = rs.getString(6);
				String dob = rs.getString(7);
				String uPassword = rs.getString(8);
				String type = rs.getString(9);
				
				User b = new User(id,name,gender,phone,uEmail,address,dob,uPassword,type);
				
				buyer.add(b);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return buyer;
		
	}
	
	//Seller Read Method
	public static List<User> getAllSellers(){
		
		List<User> seller = new ArrayList<>();
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM user WHERE type = 'Seller'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String phone = rs.getString(4);
				String uEmail = rs.getString(5);
				String address = rs.getString(6);
				String dob = rs.getString(7);
				String uPassword = rs.getString(8);
				String type = rs.getString(9);
				
				User s = new User(id,name,gender,phone,uEmail,address,dob,uPassword,type);
				
				seller.add(s);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return seller;
		
	}
	
	//Update Method
	public static boolean updateUser(String id, String name, String gender, String phone, String email, String address, String dob ) {
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String update = "UPDATE user set name = '"+name+"',gender = '"+gender+"', phone = '"+phone+"', email = '"+email+"', address = '"+address+"', dob = '"+dob+"' WHERE id = '"+id+"'";
			int rs = stmt.executeUpdate(update);
			
			//checking if successfully updated
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//Delete Method
	public static boolean deleteUser(String id) {
		
		int convId = Integer.parseInt(id);
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "delete from user where id='"+convId+"'";
    		int r = stmt.executeUpdate(sql);
    		
    		if (r > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
	}
	

}
