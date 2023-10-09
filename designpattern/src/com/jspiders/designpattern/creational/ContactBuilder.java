package com.jspiders.designpattern.creational;

public class ContactBuilder {
	
	private String firstName ;
	private String lastName ;
	private String dob ;
	private long mobileNumber ;
	private long home ;
	private int landline ;
	private String email ;
	private String webside ;
	private String address ;
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getHome() {
		return home;
	}

	public void setHome(long home) {
		this.home = home;
	}

	public int getLandline() {
		return landline;
	}

	public void setLandline(int landline) {
		this.landline = landline;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebside() {
		return webside;
	}

	public void setWebside(String webside) {
		this.webside = webside;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ContactBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this ;
	}

	public ContactBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ContactBuilder dob(String dob) {
		this.dob = dob;
		return this;
	}

	public ContactBuilder mobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
		return this;
	}

	public ContactBuilder home(long home) {
		this.home = home;
		return this;
	}

	public ContactBuilder landline(int landline) {
		this.landline = landline;
		return this;
	}

	public ContactBuilder email(String email) {
		this.email = email;
		return this;
	}

	public ContactBuilder webside(String webside) {
		this.webside = webside;
		return this;
	}

	public ContactBuilder address(String address) {
		this.address = address;
		return this;
	}
	
	public Contact contactbuilder() {
		return null;
		
	}
}
