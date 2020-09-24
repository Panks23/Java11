package com.pankaj.java;

public class MutliThreadRunnable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zelor zelo = new Zelor();
		Zolor zolo = new Zolor();
		
		System.out.println("Without Thread");
		zelo.print();
		zolo.print();
		
		System.out.println("With Thread by using runnable");
		Thread t1 = new Thread(zelo);
		Thread t2 = new Thread(zolo);
		
		t1.start();
		try {
			Thread.sleep(10);
		}catch(Exception e) {
			
		}
		
		t2.start();
		

	}

}

class Zolor implements Runnable{
	
	public void run() {
		print();
	}
	public void print() {
		for(int i=0; i<5; i++) {
			System.out.println("Zolo");
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			
		}
	}
}
}
class Zelor implements Runnable{
	
	
	public void run() {
		print();
	}
	public void print() {
		for(int i=0; i<5; i++) {
			System.out.println("Zelo");
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
		}
	}

}
