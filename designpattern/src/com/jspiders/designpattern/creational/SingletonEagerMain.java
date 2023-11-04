package com.jspiders.designpattern.creational;

public class SingletonEagerMain {

	public static void main(String[] args) {
		SingletonEager eager = SingletonEager.getObject();
		SingletonEager eager2 = SingletonEager.getObject();
		
		System.out.println(eager);
		System.out.println(eager2);
	}
}
