package com.src.concurrent.executorsbeginner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	
	private int id;
	
	public Processor(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting id: " + id);
		
		try {
			Thread.sleep(5000); // simulate task by sleeping worker thread for 5seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed id: " + id);
	}
}

public class App {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2); //Only two worker threads
		
		for(int i = 0; i < 5; i++) { //try to have 5 "Processor" tasks
			executor.submit(new Processor(i));
		}
		
		executor.shutdown(); //no more tasks can be submitted to this executor after this
		
		System.out.println("Tasks submitted..."); //this will execute before tasks are done
		
		try {
			//to make sure next line runs after all tasks are done.
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed");
	}
	
	/*
	 * One processor instance is one task that runs for 5 seconds
	 * we want to run 5 such tasks (for loop).
	 * We have two worker threads allocated (fixedthreadpoolsize = 2)
	 * Hence, in the for loop 1 thread will come in and pick up task 0,
	 * 	the next thread will pick up task 1. The thread that finishes first will then pick up
	 * 	task 2 and so on....
	 * */
}
