package com.src.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedExample {
	
	private AtomicInteger count = new AtomicInteger(0);
	
	public static void main(String[] args) {
		
		SynchronizedExample s = new SynchronizedExample();
		s.doWork();
	}
	
	private void doWork() {
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				for(int i = 0; i < 10000; i++) {
					count.incrementAndGet();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				for(int i = 0; i < 10000; i++) {
					count.incrementAndGet();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			//thread.join waits for thread to die before executing the next statement on main thread
			//we wait for both t1 and t2 to die after completing their work of 
			// incrementing count, before we print the value of count
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count is: " + count);
	}
}
