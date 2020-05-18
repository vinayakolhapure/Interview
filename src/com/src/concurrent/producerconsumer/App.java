package com.src.concurrent.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class App {

	public static void main(String[] args) {
		int BOUND = 10;
		int N_PRODUCERS = 4;
		int N_CONSUMERS = 2;//Runtime.getRuntime().availableProcessors();
		int poisonPill = Integer.MAX_VALUE;
		int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
		//if number of consumers are less than producers,
		// poisonPillPerProducer will be 0, the mod will help create
		// the required poisonPill(s) to terminate the program
		int mod = N_CONSUMERS % N_PRODUCERS;
		
		BlockingQueue<Integer> numbersQueue = new LinkedBlockingDeque<Integer>(BOUND);
		
		for(int i = 1; i < N_PRODUCERS; i++) {
			//this will insert poisonPill if N_CONSUMERS is >= N_PRODUCERS
			new Thread(new Producer(numbersQueue,poisonPill,poisonPillPerProducer)).start();
		}
		
		for(int j = 0; j < N_CONSUMERS; j++) {
			new Thread(new Consumer(numbersQueue,poisonPill)).start();
		}
		
		//this will insert poisonPill if N_CONSUMERS is < N_PRODUCERS
		new Thread(new Producer(numbersQueue, poisonPill, poisonPillPerProducer + mod)).start();
	}
}
