package com.jspiders.designpattern.creational;

public class ContactBuilder {

	private String firstName ;
	private String lastName ;
	private String dob ;
	private String email ;
	private long mobile ;
	private String website ;
	private String adress ;
	
	public ContactBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this ;
	}
	public ContactBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this ;
	}
	public ContactBuilder dob(String dob) {
		this.dob = dob;
		return this ;
	}
	public ContactBuilder setEmail(String email) {
		this.email = email;
		return this ;
	}
	public ContactBuilder mobile(long mobile) {
		this.mobile = mobile;
		return this ;
	}
	public ContactBuilder website(String website) {
		this.website = website;
		return this ;
	}
	public ContactBuilder adress(String adress) {
		this.adress = adress;
		return this ;
	}

	public Contact buildContact() {
		return new Contact(firstName, lastName, dob, email, mobile, website, adress) ;
	}
}
