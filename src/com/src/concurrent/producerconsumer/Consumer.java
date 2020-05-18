package com.src.concurrent.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	private BlockingQueue<Integer> numbersQueue;
	private final int poisonPill;
	
	public Consumer(BlockingQueue<Integer> numbersQueue, int poisonPill) {
		this.numbersQueue = numbersQueue;
		this.poisonPill = poisonPill;
	}

	@Override
	public void run() {
		try {
			while(true) {
				Integer number = numbersQueue.take();
				if (number == poisonPill) {
					System.out.println("POISON PILL: " + Thread.currentThread().getName());
					return;
				}
				System.out.println(Thread.currentThread().getName() + " result: " + number);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
