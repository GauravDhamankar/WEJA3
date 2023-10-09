package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Paratha;

public class Restorant extends Thread {
	
	private Paratha paratha ;

	public Restorant(Paratha paratha) {
		this.paratha = paratha;
	}
	
	@Override
	public void run() {
		paratha.prepareParatha(10);
	}
	
	

}
