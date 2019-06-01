package com.src.fibonacci;

/*
 * Thank you! @ https://stackoverflow.com/questions/8965006/java-recursive-fibonacci-sequence
 * */

public class FibIterativeMemo {
	public static void main(String[] args) {
		int num = 20;
		
		int[] fib = getFibo(num);
		
		for(int e : fib) {
			System.out.print(" " + e);
		}
		System.out.println("");
	}
	
	private static int[] getFibo(int num) {
		int[] fibo = new int[num];
		
		long startLoopTime = System.nanoTime();
		for(int i=0; i < num ; i++) {
			if(i == 0) {
				fibo[i] = i;
				continue;
			}
			if(i == 1 || i == 2) {
				fibo[i] = 1;
				continue;
			}
			
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		long endLoopTime = System.nanoTime();
		
		System.out.print("Time taken by loop: ");
		System.out.println(endLoopTime - startLoopTime);
		
		return fibo;
	}
}
