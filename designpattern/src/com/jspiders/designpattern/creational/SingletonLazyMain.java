package com.jspiders.designpattern.creational;

public class SingletonLazyMain {

	public static void main(String[] args) {
		SingletonLazy lazy1 = SingletonLazy.getObject();
		SingletonLazy lazy2 = SingletonLazy.getObject();
		SingletonLazy lazy3 = SingletonLazy.getObject();
		
		System.out.println(lazy1);
		System.out.println(lazy2);
		System.out.println(lazy3);
	}
}
