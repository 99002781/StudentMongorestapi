package com.lts.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
@Document(collection="student")
@Component

public class Student {
	@Id
	Integer StdId;
	Integer age;
	String name;
	String department;
	@Autowired
	Address address;
	

	public Student(Integer stdId, Integer age, String name, String department, Address address) {
		super();
		StdId = stdId;
		this.age = age;
		this.name = name;
		this.department = department;
		this.address = address;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getStdId() {
		return StdId;
	}

	public void setStdId(Integer stdId) {
		StdId = stdId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [StdId=" + StdId + ", age=" + age + ", name=" + name + ", department=" + department
				+ ", address=" + address + "]";
	}

	public Student orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
