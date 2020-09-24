package com.pankaj.java;

import java.util.concurrent.atomic.AtomicInteger;

public class TaskAtomic implements  Runnable{ 
	
	public final AtomicInteger number;
	
	public TaskAtomic() {
		this.number = new AtomicInteger();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i <1000000; i++) {
			number.set(i);
		}
		
	}

}
