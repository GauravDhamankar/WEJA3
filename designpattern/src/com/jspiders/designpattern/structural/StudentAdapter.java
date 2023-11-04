package com.jspiders.designpattern.structural;

public class StudentAdapter extends Studetn implements Game {

	@Override
	public void football() {
		setId(1);
		setName("Gaurav");
		setAge(23);
		System.out.println(getName() + " is captain of football team."); 
	}

	@Override
	public void cricket() {
		setId(2);
		setName("Tejas");
		setAge(22);
		System.out.println(getName() + " is captain of cricket team.");
	}

}
