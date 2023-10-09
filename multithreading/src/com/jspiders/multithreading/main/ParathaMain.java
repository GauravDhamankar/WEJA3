package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.Paratha;
import com.jspiders.multithreading.thread.Customer;
import com.jspiders.multithreading.thread.Customer2;
import com.jspiders.multithreading.thread.Restorant;

public class ParathaMain {

	public static void main(String[] args) {
		Paratha paratha = new Paratha();
		Customer customer = new Customer(paratha);
		Customer2 customer2 = new Customer2(paratha);
		Restorant restorant = new Restorant(paratha);
		
		customer.start();
		customer2.start();
		restorant.start();
	}
}
