package com.jspiders.designpattern.creational;

public class TeacherAdapter extends Teacher implements Game{

	@Override
	public void football() {
		setId(3);
		setName("Rohit");
		setEmail("rohit@gmail.com");
		System.out.println(getName() + " is teacher of football team.");
	}

	@Override
	public void hockey() {
		setId(4);
		setName("Ashutosh");
		setEmail("ashutosh@gmail.com");
		System.out.println(getName() + " is a teacher of hockey team.");
	}

}
