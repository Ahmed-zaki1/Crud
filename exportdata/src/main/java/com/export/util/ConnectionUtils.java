package com.export.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class ConnectionUtils {

	static Logger log = Logger.getLogger(ConnectionUtils.class.getName());

	static String DRIVER = "org.postgresql.Driver";
	static String URL = "jdbc:postgresql://pglogical2-rdscluster-1acqgioj41xox.cluster-caq5m9vcrmcb.eu-west-1.rds.amazonaws.com:5432/pgwlogical2?currentSchema=myschema";
	static String USERNAME = "pgwuserlogical2dev";
	static String PASSWORD = "~p!&yQw)f!+CPBWxZXn(vT2<cFOB0V:r";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			log.info("Connected Successfully");
		} catch (Exception e) {

			log.error(e);
		}
		return connection;

	}

}
