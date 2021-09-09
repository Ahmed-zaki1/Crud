package com.export.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.export.entity.Users;
import com.export.s3config.AWSS3Service;
import com.export.s3config.MyS3Config;
import com.export.util.CommonUtil;

public class DbToCsv {

	AWSS3Service awss3Service;

	static Logger log = Logger.getLogger(DbToCsv.class.getName());

	public static void insertData(List<Users> tranList) {

		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());

		String header = "Users_" + currentDateTime + ".csv";
		File file = new File(header);
		log.info("Csv File have been generated");
		try (FileWriter fw = new FileWriter(file);
				CsvBeanWriter csvWriter = new CsvBeanWriter(fw, CsvPreference.STANDARD_PREFERENCE);) {
			String[] headerName = { "UUID", "transaction_id", "parent_transaction_id", "transaction_type",
					"transaction_amount", "transaction_currency", "poi_id", "poi_type", "poi_sub_type",
					"transaction_method", "create_time", "update_time", "merchant_payment_gw_id", "exchange_id",
					"message_function", "activity_name", "activity_status", "additional_info", "transaction_amount_txt",
					"process_id" };
			String[] nameMapping = { "id", "transaction_id", "parent_transaction_id", "transaction_type",
					"transaction_amount", "transaction_currency", "poi_id", "poi_type", "poi_sub_type",
					"transaction_method", "create_time", "update_time", "merchant_payment_gw_id", "exchange_id",
					"message_function", "activity_name", "activity_status", "additional_info", "transaction_amount_txt",
					"process_id" };
			csvWriter.writeHeader(headerName);
			log.info("Csv Header have been generated as per the Data Column in Table");
			tranList.forEach(u -> {
				try {
					csvWriter.write(u, nameMapping);
					log.info("Table Data have been put in Csv File");
					CommonUtil.uploadFileToS3Bucket(CommonUtil.bucketName, file, MyS3Config.AmazonS3ClientBuilder(),
							CommonUtil.endPointURL);
					log.info("Csv File Have been put in S3 Bucket");
				} catch (IOException e) {
					log.warn(e);
				}
			});

		} catch (Exception e) {
			log.warn(e);
		}

	}

}
