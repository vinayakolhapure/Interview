package com.src.concurrent.locks;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Worker {
	
	Random random = new Random();
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();
	
	public synchronized void stageOne() {
		
		try {
			Thread.sleep(1); //simulate an api call
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list1.add(random.nextInt(100));
	}
	
	public synchronized void stageTwo() {
		try {
			Thread.sleep(1); //simulate an api call
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list2.add(random.nextInt(100));
	}

	public void process() {
		for (int i=0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() {
		System.out.println("Starting....");
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();
		t2.start();
		
		//wait for t1 to die before executing the below lines
		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken: " + (end - start));
		
		System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
	}
}
