package com.jspiders.designpattern.creational;

public class StudentAdapter extends Student implements Game {

	@Override
	public void football() {
		setId(1);
		setName("Gaurav");
		setEmail("gaurav@gmail.com");
		System.out.println(getName() + " is captain of football team.");
	}

	@Override
	public void hockey() {
		setId(2);
		setName("Tejas");
		setEmail("tejas@gmail.com");
		System.out.println(getName() + " is captain of hockey team.");
	}

}
