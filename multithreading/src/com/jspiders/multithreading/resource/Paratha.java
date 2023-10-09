package com.jspiders.multithreading.resource;

public class Paratha {

	private int availableParatha ;
	
	public synchronized void orderParatha(int numberOfParatha) {
		if (numberOfParatha > availableParatha) {
			System.out.println(numberOfParatha + " parathas are not available, wait for some time.");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			availableParatha -= numberOfParatha;
			System.out.println(numberOfParatha + " are ordered successfully.");
		}
	}
	
	public synchronized void prepareParatha(int numberOfParatha) {
		System.out.println(numberOfParatha + " are preparing");
		availableParatha += numberOfParatha ;
		System.out.println(numberOfParatha + " are ready.");
		notifyAll();
	}
 	
	
}
