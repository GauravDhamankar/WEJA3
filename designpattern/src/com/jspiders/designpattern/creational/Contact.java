package com.jspiders.designpattern.creational;

public class Contact {

	private String firstName ;
	private String lastName ;
	private String dob ;
	private String email ;
	private long mobile ;
	private String website ;
	private String adress ;
	
	public Contact(String firstName, String lastName, String dob, String email, long mobile, String website,
			String adress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.website = website;
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", email=" + email
				+ ", mobile=" + mobile + ", website=" + website + ", adress=" + adress + "]";
	}
	
	
	
}
