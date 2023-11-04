package com.jspiders.designpattern.creational;

public class ContactMain {

	public static void main(String[] args) {
		Contact contact = new ContactBuilder().mobile(897967564).firstName("Gaurav").buildContact();
		
		System.out.println(contact);
	}
}
