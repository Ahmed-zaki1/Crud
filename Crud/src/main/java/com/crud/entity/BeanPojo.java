package com.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "finicity")
public class BeanPojo {
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "mobile")
	private Long mobile;
	@Column(name = "surname")
	private String surname;
	@Column(name = "pincode")
	private String pincode;

	public BeanPojo() {
		super();

	}

	public BeanPojo(int id, String name, String address, Long mobile, String surname, String pincode) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.surname = surname;
		this.pincode = pincode;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "BeanPojo [Id=" + Id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", surname="
				+ surname + ", pincode=" + pincode + "]";
	}

	
}
