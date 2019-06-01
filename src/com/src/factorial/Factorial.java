package com.src.factorial;

public class Factorial {
	public static void main(String[] args) {
		
		int n = 5;
		long startTime = System.nanoTime();
		System.out.println(factorial(n));
		long endTime = System.nanoTime();
		System.out.print("Time taken by classic recursive solution: ");
		System.out.println(endTime - startTime);
		
		
		long startTimeM = System.nanoTime();
		System.out.println(factorialMemo(n));
		long endTimeM = System.nanoTime();
		System.out.print("Time taken by recursive memo: ");
		System.out.println(endTimeM - startTimeM);
		
		
		long startTimeI = System.nanoTime();
		System.out.println(factorialIter(n));
		long endTimeI = System.nanoTime();
		System.out.print("Time taken by Iterative: ");
		System.out.println(endTimeI - startTimeI);
	}
	
	private static int factorial(int n) {
		
		if(n < 0) {
			throw new IllegalArgumentException("n should be greater than or equal to 0.");
		}
		
		if(n == 0 || n == 1) {
			return 1;
		}
		
		return n* factorial(n-1);
	}
	
	private static int factorialMemo(int n) {
		
		int[] a = new int[n+1];
		
		if (n < 0) {
			throw new IllegalArgumentException("n should be greater than or equal to 0.");
		}
		
		if(n == 0 || n == 1) {
			a[n] = 1;
			return a[n];
		}
		
		if(a[n] == 0) {
			a[n] = n * factorialMemo(n-1);
		}
		return a[n];
	}
	
	private static int factorialIter(int n) {
		
		int[] a = new int[n+1];
		
		if(n < 0) {
			throw new IllegalArgumentException("n should be greater than or equal to 0.");
		}
		
		if(n == 0) {
			return 1;
		}
		
		for(int i = 1 ; i <= n ; i++) {
			if(i == 1) {
				a[i] = 1;
				continue;
			}
			
			a[i] = i * a[i-1];
		}
		return a[n];
	}
}
