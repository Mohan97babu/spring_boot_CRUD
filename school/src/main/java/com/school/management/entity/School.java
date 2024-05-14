package com.school.management.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
public class School {
	@Id
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="address_1")
	private String address1;
	@Column(name="address_2")
	private String address2;
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress_1() {
		return address1;
	}
	public void setAddress_1(String address_1) {
		this.address1 = address_1;
	}
	public String getAddress_2() {
		return address2;
	}
	public void setAddress_2(String address_2) {
		this.address2 = address_2;
	}
}
