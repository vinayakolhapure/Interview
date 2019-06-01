package com.src.fibonacci;


public class FibRecursiveMemo {
	
	static int[] memo;
	
	public static void main(String[] args) {
		int num = 6;
		
		for(int i = 0 ; i < num ; i++) {
			System.out.print(" " + fibonacci(i));
		}
		System.out.println(" ");
	}
	
	public static int fibonacci(int n) {
		memo = new int[n+1];
	    return fibonacci(n, memo);
	}

	public static int fibonacci(int i, int[] memo) {

	    if (i == 0 || i == 1) {
	    	memo[i] = i;
	        return i;
	    }

	    if (memo[i] == 0) {
	        memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
	    }
	    return memo[i];
	}
}
