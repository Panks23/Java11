package com.pankaj.java;

import java.util.Date;

public class AtomicVsLockMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TaskAtomic atomicTask = new TaskAtomic();
		TaskLock lockTask = new TaskLock();
		
		int numberThreads = 50;
		Thread threads[] = new Thread[numberThreads];
		
		Date begin, end;
		begin = new Date();
		for(int i=0; i<numberThreads; i++) {
			threads[i] = new Thread(lockTask);
			threads[i].start();
		}
		
		
		for(int i=0; i<numberThreads; i++) {
			try {
				threads[i].join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		end = new Date();
		
		System.out.printf("Main Lock Results: %d\n", (end.getTime()-begin.getTime()));
		
		
		begin = new Date();
		for(int i=0; i<numberThreads; i++) {
			threads[i] = new Thread(atomicTask);
			threads[i].start();
		}
		
		
		for(int i=0; i<numberThreads; i++) {
			try {
				threads[i].join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		end = new Date();
		
		System.out.printf("Main Atomic Results: %d\n", (end.getTime()-begin.getTime()));

	}

}
