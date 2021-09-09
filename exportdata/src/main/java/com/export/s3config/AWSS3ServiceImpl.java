package com.export.s3config;

import static com.export.util.CommonUtil.uploadFileToS3Bucket;

import java.io.File;

import com.amazonaws.services.s3.AmazonS3;

public class AWSS3ServiceImpl {

	public AmazonS3 amazonS3;

	public AWSS3ServiceImpl(final AmazonS3 amazonS3) {
		super();
		this.amazonS3 = amazonS3;
	}

	public String uploadFile(final File file, String bucketName, String endPointUrl) {
		String returnURL = uploadFileToS3Bucket(bucketName, file, amazonS3, endPointUrl);
		file.delete();
		return returnURL;
	}
}
