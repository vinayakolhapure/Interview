package com.src.practice;

/*
 * Problem: https://leetcode.com/problems/maximum-subarray/
 * Thank you: https://www.youtube.com/watch?v=86CQq3pKSUw
 * */

public class MaxSumSubArray {
	public static void main(String[] args) {
		//[-2,1,-3,4,-1,2,1,-5,4] = 6
		//[1,-3,2,1,-1] = 3
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		//int[] a = {1,-3,2,1,-1};
		
		System.out.println(maxSumSubarray(a));
	}
	
	public static int maxSumSubarray(int[] a) {
		
		int maxCurr = a[0];
		int maxGlobal = a[0];
		
		for(int i = 1 ; i < a.length ; i++) {
			
			maxCurr = Math.max(a[i], a[i] + maxCurr);
			
			if(maxCurr > maxGlobal) {
				maxGlobal = maxCurr;
			}
		}
		
		return maxGlobal;
	}
}
