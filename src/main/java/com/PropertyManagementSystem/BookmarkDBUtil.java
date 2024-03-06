package com.PropertyManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookmarkDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	// Insert Method
	public static boolean addBookmark(int PID, int BID, String pName, String pOwner, double pAmount, String pAddress, String oContact) {

		boolean isSuccess = false;

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();
			// insert query
			String insert = "INSERT INTO bookmark VALUES(0,'"+PID+"', '"+BID+"', '"+pName+"', '"+pOwner+"', '"+pAmount+"', '"+pAddress+"', '"+oContact+"')";
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
	
	//Read Method
	public static List<Bookmark> getBookmarks(int BID) {

		List<Bookmark> bMark = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "Select * from bookmark where BID = '"+BID+"'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int bookID = rs.getInt(1);
				int bPID = rs.getInt(2);
				int bBID = rs.getInt(3);
				String pName = rs.getString(4);
				String pOwner = rs.getString(5);
				double pAmount = rs.getDouble(6);
				String pAddress = rs.getString(7);
				String oContact = rs.getString(8);

				Bookmark b = new Bookmark(bookID, bPID, bBID, pName, pOwner, pAmount, pAddress, oContact);

				bMark.add(b);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bMark;

	}
	
	//Delete Method
	public static boolean deleteBookmark(String BID) {

		int convId = Integer.parseInt(BID);

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "delete from bookmark where bookID='" + convId + "'";
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
