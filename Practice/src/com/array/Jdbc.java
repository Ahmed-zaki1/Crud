package com.array;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ob_s", "root", "root");
			Statement St = conn.createStatement();
			ResultSet rs = St.executeQuery("Select * from zaki");
			System.out.println(conn);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
