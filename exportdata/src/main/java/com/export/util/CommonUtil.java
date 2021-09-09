package com.export.util;

import java.io.File;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

public interface CommonUtil {
	public static String bucketName = "mycsvbuckets";
	public static String endPointURL = "http://mycsvbuckets.s3-website-us-east-1.amazonaws.com";

	public static String uploadFileToS3Bucket(final String bucketName, final File file, AmazonS3 amazonS3, String endPointURL) {
        final String uniqueFileName =  file.getName();
        final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
        amazonS3.putObject(putObjectRequest);
        return endPointURL+"/"+uniqueFileName;
    }

}
