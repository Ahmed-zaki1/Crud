package com.crud.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import com.crud.entity.BeanPojo;

public interface Service {

	List<BeanPojo> getUser();

	BeanPojo getUserById(int id);

	List<BeanPojo> getUserByName(String name);

	Page<BeanPojo> getUserByPincode(String pincode, PageRequest page);

	BeanPojo saveUser(BeanPojo bean);

	List<BeanPojo> saveUsers(List<BeanPojo> bean);

	BeanPojo update(BeanPojo bean, int id);

	void deleteUserByName(String name);

	void deleteUserById(int id);

	void init();

	String saveFile(MultipartFile file);
	public void save(MultipartFile file);

	Resource loadFile(String fileName);

}
