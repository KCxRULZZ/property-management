package com.PropertyManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuyerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	// reading seller details
	public static List<User> getBuyer(int id) {

		List<User> buyer = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "Select * from user where id = " + id + "";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {

				int BID = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				String phone = rs.getString(4);
				String uEmail = rs.getString(5);
				String address = rs.getString(6);
				String dob = rs.getString(7);
				String uPassword = rs.getString(8);
				String type = rs.getString(9);

				User u = new User(BID, name, gender, phone, uEmail, address, dob, uPassword, type);

				// adding details to user array list
				buyer.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return buyer;

	}
	
	//Delete Buyer Bookmarks
	public static boolean deleteBookmark(String BID) {

		int convId = Integer.parseInt(BID);

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "delete from bookmark where BID='" + convId + "'";
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
