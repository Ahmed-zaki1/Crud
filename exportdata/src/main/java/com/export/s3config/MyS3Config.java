package com.export.s3config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class MyS3Config {

	public static String accessKeyId = "AKIA27B3VZFODHS6HINF";

	public static String secretAccessKey = "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";

	public static AmazonS3 AmazonS3ClientBuilder() {
		final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKeyId, secretAccessKey);
		// Get AmazonS3 client and return the s3Client object.
		return AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials)).build();
	}
}
