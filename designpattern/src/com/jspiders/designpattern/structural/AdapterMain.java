package com.jspiders.designpattern.structural;

public class AdapterMain {

	public static void main(String[] args) {
		StudentAdapter adapter = new StudentAdapter();
		adapter.football();
		adapter.cricket();
	}
}
