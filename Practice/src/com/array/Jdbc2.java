package com.array;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Jdbc2 {
	public static void main(String[] args) {
		String DRIVER = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/ob_s";
		String USERNAME = "root";
		String PASSWORD = "root";
		PreparedStatement ps;
		ResultSet rs;
		String sql;
		String sql1;
		String sql2;
		String sql3;
		try {
			Class.forName(DRIVER);
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			sql = "select * from zaki";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3));
			}
			sql1 = "INSERT INTO zaki (Id, Name,Date) VALUES (?, ?, ?)";
			sql2 = "delete from zaki where Id=?";
			sql3 = "UPDATE zaki SET Name=?, Date=? WHERE Id=?";
			ps = connection.prepareStatement(sql3);
			ps.setString(1, "Bushra");
			ps.setDate(2, new Date(2021-8-12));
			ps.setInt(3, 4);
			/*
			 * ps.setInt(1, 8); ps.setString(2, "Arshad"); ps.setDate(3, new Date(2021 - 8 -
			 * 04));
			 */
			int row = ps.executeUpdate();
			if (row > 0) {
				System.out.println("Updated");
			}
			;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
