package com.crud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crud.entity.BeanPojo;
import com.crud.entity.FileResponse;
import com.crud.service.Service;

import springfox.documentation.service.ResponseMessage;

@RestController
@RequestMapping("/api")
public class Control {

	@Autowired
	private Service service;

	@GetMapping("/")
	public List<BeanPojo> getUser() {
		return service.getUser();
	}

	@GetMapping("/getusers/{id}")
	public ResponseEntity<BeanPojo> getUserById(@PathVariable("id") int id) {

		return new ResponseEntity<BeanPojo>(service.getUserById(id), HttpStatus.OK);
	}

	@GetMapping("/getUser/{name}")
	public ResponseEntity<List<BeanPojo>> getUserByName(@PathVariable("name") String name) {
		return new ResponseEntity<List<BeanPojo>>(service.getUserByName(name), HttpStatus.OK);
	}

	@GetMapping("/getdata/{pincode}")
	public ResponseEntity<Page<BeanPojo>> getUserByPincode(@PathVariable("pincode") String pincode) {

		return new ResponseEntity<Page<BeanPojo>>(service.getUserByPincode(pincode, PageRequest.of(0, 2)),
				HttpStatus.OK);
	}

	@PostMapping("/saveuser")
	public ResponseEntity<BeanPojo> saveUser(@RequestBody BeanPojo bean) {

		return new ResponseEntity<BeanPojo>(service.saveUser(bean), HttpStatus.CREATED);
	}

	@PostMapping("/saveusers")
	public ResponseEntity<List<BeanPojo>> saveUsers(@RequestBody List<BeanPojo> bean) {
		return new ResponseEntity<List<BeanPojo>>(service.saveUsers(bean), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody BeanPojo bean) {
		service.update(bean, id);
		return new ResponseEntity<String>("id no:" + id + " has been updated successfully", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") int id) {
		service.deleteUserById(id);
		return new ResponseEntity<String>("id no:" + id + " has been deleted successfully", HttpStatus.OK);
	}

	@DeleteMapping("/delete/{name}")
	public ResponseEntity<String> deleteUserByName(@PathVariable("name") String name) {
		service.deleteUserByName(name);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@PostMapping("/uploadFile")
	public ResponseEntity<FileResponse> uploadSingleFile(@RequestParam("file") MultipartFile file) {
		String upfile = service.saveFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("C:/Users/agamy/Desktop/File").path(upfile).toUriString();
		return ResponseEntity.status(HttpStatus.OK)
				.body(new FileResponse(upfile, fileDownloadUri, "File uploaded with success!"));
	}

	/*
	 * @PostMapping("/uploadfiles") public ResponseEntity<List<FileResponse>>
	 * uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
	 * 
	 * List<FileResponse> responses = Arrays.asList(files).stream().map(file -> {
	 * String upfiles = service.saveFile(file);
	 * responses.add(file.getOriginalFilename()); String fileDownloadUri =
	 * ServletUriComponentsBuilder.fromCurrentContextPath()
	 * .path("C:/Users/agamy/Desktop/File").path(upfiles).toUriString(); return new
	 * FileResponse(upfiles, fileDownloadUri, "File uploaded with success!");
	 * }).collect(Collectors.toList());
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(responses);
	 * 
	 * }
	 */
	
	 @PostMapping("/upload")
	  public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] files) {
	    String message = "";
	    try {
	      List<String> fileNames = new ArrayList<>();

	      Arrays.asList(files).stream().forEach(file -> {
	    	 service.save(file);
	        fileNames.add(file.getOriginalFilename());
	      });

	      message = "Uploaded the files successfully: " + fileNames;
	     return  ResponseEntity.of(Optional.of(message));
	    } catch (Exception e) {
	      message = "Fail to upload files!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
	    }
	  }

	@GetMapping("/download/{filename:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {

		Resource resource = service.loadFile(filename);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}