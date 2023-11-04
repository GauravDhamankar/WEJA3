package com.jspiders.designpattern.creational;

public class SingletonEager {

	private static SingletonEager singletonEager = new SingletonEager();
	
    private SingletonEager() {
		
	}
	
	public static SingletonEager getObject() {
		return singletonEager;
	}
}
