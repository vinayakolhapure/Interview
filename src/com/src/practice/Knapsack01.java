package com.src.practice;

/*
 * Source code: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 * Video explanation: https://www.youtube.com/watch?v=8LusJS5-AGo
 * */

public class Knapsack01 {

	public static void main(String[] args) {
		int[] wt = {1,2,3};
		int[] val = {60,100,120};
		int W = 5;
		int n = wt.length;
		
		System.out.println(knapsack01(wt,val,W,n));
	}
	
	public static int knapsack01(int[] wt, int[] val, int W, int n) {
		
		int[][] K = new int[n+1][W+1]; //rows = 0,1,2,3 (n+1). cols = 0,1,2,3,......5 (W+1)
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= W; j++) {
				if(i == 0 || j == 0) {
					K[i][j] = 0;
					continue;
				}
				
				if(wt[i-1] <= j) { //wt[i-1] or val[i-1] because matrix of i or j means i-1 or j-1 in input arrays
					//max(selected val + val of remaining weight, val of previous item at that weight)
					K[i][j] = Math.max(val[i-1] + K[i-1][j-wt[i-1]], K[i-1][j]); 
				} else {
					K[i][j] = K[i-1][j];
				}
			}
		}
		
		return K[n][W];
	}
}
