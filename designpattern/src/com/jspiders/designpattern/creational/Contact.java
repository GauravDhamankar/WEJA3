package com.jspiders.designpattern.creational;

public class Contact {

	private String firstName ;
	private String lastName ;
	private String dob ;
	private long mobileNumber ;
	private long home ;
	private int landline ;
	private String email ;
	private String webside ;
	private String address ;
	
	public Contact(String firstName, String lastName, String dob, long mobileNumber, long home, int landline,
			String email, String webside, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.home = home;
		this.landline = landline;
		this.email = email;
		this.webside = webside;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", mobileNumber="
				+ mobileNumber + ", home=" + home + ", landline=" + landline + ", email=" + email + ", webside="
				+ webside + ", address=" + address + "]";
	}

	
	
}
