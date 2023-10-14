package com.jspiders.designpattern.creational;

public class SingletonEagerMain {

	public static void main(String[] args) {
		SingletonEager eager1 = SingletonEager.getObject();
		SingletonEager eager2 = SingletonEager.getObject();
		SingletonEager eager3 = SingletonEager.getObject();
		
		System.out.println(eager1);
		System.out.println(eager2);
		System.out.println(eager3);
	}
}
