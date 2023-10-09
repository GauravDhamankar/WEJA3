package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Paratha;

public class Customer2 extends Thread{
	
	private Paratha paratha ;

	public Customer2(Paratha paratha) {
		this.paratha = paratha;
	}
	
	@Override
	public void run() {
		paratha.orderParatha(10);
	}
	
	

}
