package com.jspiders.multithreading.resource;

public class Resource {
	
	public void message() {
		System.out.println("Running : "+Thread.currentThread().getName());
	}
}
