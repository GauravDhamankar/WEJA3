package com.jspiders.designpattern.creational;

public class SingletonLazyMain {

	public static void main(String[] args) {
		SingletonLazy lazy = SingletonLazy.getObject();
		SingletonLazy lazy2 = SingletonLazy.getObject();
		
		System.out.println(lazy);
		System.out.println(lazy2);
	}
}
