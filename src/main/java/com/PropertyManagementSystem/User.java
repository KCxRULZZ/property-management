package com.PropertyManagementSystem;

public class User {
	
	private int id;
	private String name;
	private String gender;
	private String phone;
	private String email;
	private String address;
	private String dob;
	private String password;
	private String type;
	
	public User(int id, String name, String gender, String phone, String email, String address, String dob,String password, String type) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.dob = dob;
		this.password = password;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getDob() {
		return dob;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}
	
	
}
