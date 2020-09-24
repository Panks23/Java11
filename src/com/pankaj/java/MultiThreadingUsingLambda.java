package com.pankaj.java;

public class MultiThreadingUsingLambda {

	public static void main(String[] args) throws InterruptedException {
		
		
		Counter c = new Counter();
		 
		Thread t = new Thread(()-> {
			for(int i =1; i<=1000; i++) {
				c.increment();
			}
		});
		Thread t0 = new Thread(()-> {
			for(int i =1; i<=1000; i++) {
				c.increment();
			}
		});
		t.start();
		t0.start();
		t.join();
		t0.join();
		System.out.println(c.count+" Kyu hila dala naa(in Rajnikant Style)");
		// TODO Auto-generated method stub
		CounterSyn p = new CounterSyn();
		t = new Thread(()-> {
			for(int i =1; i<=1000; i++) {
				p.increment();
			}
		});
		
		t0 =  new Thread(()-> {
			for(int i =1; i<=1000; i++) {
				p.increment();
			}
		});
		t.start();
		t0.start();
		t.join();
		t0.join();
		
		System.out.println(p.count+" Kya mtlb jo answer tha wahi print hoga naa");
		
		
		System.out.println("With Thread by using lambda");
		Thread t1 = new Thread(()-> {
			for(int i=0; i<5; i++) {
				System.out.println("Zolo"+ Thread.currentThread().getPriority());
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				
			}
		}
		});
		Thread t2 = new Thread(()->{for(int i=0; i<5; i++) {
			System.out.println("Zelo");
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			
		}
	}
	});
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(7);
		t1.start();
		try {
			Thread.sleep(10);
		}catch(Exception e) {
			
		}
		
		
		t2.start();
		
		System.out.println("Thread t1 is alive: "+t1.isAlive());
		System.out.println("Thread t2 is alive: "+t1.isAlive());

	
		t1.join();
		t2.join();
		System.out.println("Bye");
		System.out.println("Thread t1 is alive: "+t1.isAlive());
		System.out.println("Thread t2 is alive: "+t1.isAlive());
	}

}

class Counter{
	int count;
	public void increment() {
		count++;
	}
}

class CounterSyn{
	int count;
	public synchronized void increment() {
		count++;
	}
}
