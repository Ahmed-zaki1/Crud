package com.export;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.export.csv.DbToCsv;
import com.export.entity.Users;
import com.export.util.ConnectionUtils;

public class App {
	static Logger log = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				Connection conn = ConnectionUtils.getConnection()) {
			log.info("Enter The Nth Number");
			int days = Integer.parseInt(reader.readLine());
			sql = "SELECT * FROM transaction_activity_table WHERE create_datetime  NOT BETWEEN ? AND CURDATE()";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, LocalDate.now().minusDays(days).toString());
			rs = pstmt.executeQuery();
			log.info("Query Fired");
			Users bean = null;
			List<Users> tranList = new ArrayList<>();
			while (rs.next()) {
				bean = new Users();
				bean.setId(rs.getLong(1));
				bean.setTransaction_id(rs.getString(2));
				bean.setParent_transaction_id(rs.getString(3));
				bean.setTransaction_type(rs.getString(4));
				bean.setTransaction_amount(rs.getLong(5));
				bean.setTransaction_currency(rs.getString(6));
				bean.setPoi_id(rs.getString(7));
				bean.setPoi_type(rs.getString(8));
				bean.setPoi_sub_type(rs.getString(9));
				bean.setTransaction_method(rs.getString(10));
				bean.setCreate_time(rs.getTimestamp(11));
				bean.setUpdate_time(rs.getTimestamp(12));
				bean.setMerchant_payment_gw_id(rs.getString(13));
				bean.setExchange_id(rs.getString(14));
				bean.setMessage_function(rs.getString(15));
				bean.setActivity_name(rs.getString(16));
				bean.setActivity_status(rs.getString(17));
				bean.setAdditional_info(rs.getString(18));
				bean.setTransaction_amount_txt(rs.getString(19));
				bean.setProcess_id(rs.getString(20));

				tranList.add(bean);
				log.info("Data have been stored in Bean class");
			}
			if (!tranList.isEmpty()) {
				DbToCsv.insertData(tranList);
				sql = "delete FROM transaction_activity_table WHERE create_datetime NOT BETWEEN ? AND CURDATE()";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, LocalDate.now().minusDays(days).toString());
				int delete = pstmt.executeUpdate();
				log.info("Delete Query Fired");
				log.info(delete + "Records have been Purged");

			} else
				log.warn("No Such Date Found");

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}

	}

}