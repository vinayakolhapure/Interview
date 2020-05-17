package com.src.concurrent.countdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {
	private List<String> outputScrapper;
	private CountDownLatch countDownLatch;
	
	public Worker(List<String> outputScrapper, CountDownLatch countDownLatch) {
		this.outputScrapper = outputScrapper;
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			outputScrapper.add("Counted Down");
			countDownLatch.countDown(); //each task counting down after doing work
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class App {

	public static void main(String[] args) {
		List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
		CountDownLatch countDownLatch = new CountDownLatch(5);
		
		for(int i = 0; i < 5; i++) {
			new Thread(new Worker(outputScraper,countDownLatch)).start();
		}
		
		try {
			//wait for all workers to finish i.e., countdownLatch comes to 0
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		outputScraper.add("Latch released");
		
		System.out.println(outputScraper.toString());
	}
}
