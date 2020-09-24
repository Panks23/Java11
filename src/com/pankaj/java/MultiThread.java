package com.pankaj.java;

public class MultiThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Zelo zelo = new Zelo();
		Zolo zolo = new Zolo();
		
		System.out.println("Without Thread");
		zelo.print();
		zolo.print();
		
		System.out.println("With Thread");
		zelo.start();
		zolo.start();
		

	}

}

class Zolo extends Thread{
	
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
class Zelo extends Thread{
	
	
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
