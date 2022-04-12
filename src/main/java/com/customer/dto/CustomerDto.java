package com.customer.dto;

public class CustomerDto {
	private String name;
	private String email;
	private String contactNumber;
	private String address;
	private String password;
	private int age;
	private String Gender;
	
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(String name, String email, String contactNumber, String address, String password, int age,
			String gender) {
		super();
		this.name = name;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
		this.password = password;
		this.age = age;
		Gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", email=" + email + ", contactNumber=" + contactNumber + ", address="
				+ address + ", password=" + password + ", age=" + age + ", Gender=" + Gender + "]";
	}
	
	

}
