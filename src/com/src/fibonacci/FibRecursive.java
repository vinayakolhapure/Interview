package com.src.fibonacci;

public class FibRecursive {
	public static void main(String[] args) {
		
		int n = 5;
		
		//to print the series - just call the fibo function in a loop and keep returning Ith number.
		for(int i=0 ; i < n ; i++) {
			System.out.println(getNthFibonacciNumber(i));
		}
	}

	private static int getNthFibonacciNumber(int n) {
		
		if(n<=0) {
			return 0;
		}
		
		if(n == 1 || n == 2) {
			return 1;
		}
		
		return getNthFibonacciNumber(n-1) + getNthFibonacciNumber(n-2); 
	}
}
