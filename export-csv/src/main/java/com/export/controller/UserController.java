package com.export.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.export.entity.Users;
import com.export.repo.UserReop;
import com.amazonaws.services.s3.AmazonS3Encryption;
import com.export.awsconfig.AWSConfig;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserReop userRepository;

	@Autowired
	private AWSConfig AWSS3;

	// get all users
	@GetMapping
	public List<Users> getAllUsers() {
		
		return this.userRepository.findAll();
	}

	// get user by id
	/*
	 * @GetMapping("/{id}") public Users getUserById(@PathVariable(value = "id")
	 * long userId) { return this.userRepository.findById(userId) .orElseThrow(() ->
	 * new ResourceNotFoundException("User not found with id :" + userId)); }
	 */

	@GetMapping("/export")
	public void exportToCSV(HttpServletResponse response,AmazonS3Encryption s3 ) throws IOException {
		response.setContentType("text/csv");

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "Users " + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);

		List<Users> listUsers = userRepository.findAll();
		File file=new File("C:/Users/agamy/Desktop/New folder/"+headerValue);
		s3.putObject("mycsvbuckets", "AKIA27B3VZFONMUFF3NK", file);
		
		
		
		FileWriter outputfile = new FileWriter(file);

		ICsvBeanWriter csvWriter = new CsvBeanWriter(outputfile, CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "User ID", "EMAIL", "FIRST Name", "LAST NAME" };
		String[] nameMapping = { "id", "email", "firstName", "lastName" };

		csvWriter.writeHeader(csvHeader);

		for (Users user : listUsers) {
			csvWriter.write(user, nameMapping);
		}
		if (listUsers != null) {
			userRepository.deleteAll();
		}

		csvWriter.close();

	}

}
