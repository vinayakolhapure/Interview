package com.src.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Map approach uses O(N) time and O(N) space
 * 
 * We can instead use the XOR operation. We know that the array has exactly one lonely int.
 * Hence, all other elements that occur more than once when XORd with each other give 0.
 * (recap: in XOR -- 0 XOR 1 = 1, 0 XOR 0 = 0, 1 XOR 1 = 1 --> N XOR N = N)
 * 
 * So, when we XOR all elements in the array - we are basically doing 0 XOR LONELY_INT ==> LONELY_INT
 * 
 * **** The XOR method will only work when all other numbers except the lonely are in pairs. **** 
 * 
 * Problem statement: https://www.hackerrank.com/challenges/lonely-integer/problem
 * Credit: https://www.youtube.com/watch?v=eXWjCgbL01U&list=PLI1t_8YX-ApvMthLj56t1Rf-Buio5Y8KL&index=15
 * */

public class LonelyInteger {
	public static void main(String[] args) {
		int[] a = new int[] {9,1,2,3,2,9,1,7,7};
		
		int resultBitOp = lonelyByXOR(a);
		System.out.println(resultBitOp);
		
		int result = lonelyIntegerUsingMap(a);
		System.out.println(result);
	}
	
	private static int lonelyByXOR(int[] a) {
		int result = 0;
		
		for(int value : a) {
			result ^= value;
		}
		return result;
	}
	
	private static int lonelyIntegerUsingMap(int[] a) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int value : a) {
			if(!map.containsKey(value)) {
				map.put(value, 1);
			} else {
				int freq = map.get(value);
				freq +=1;
				map.put(value,freq);
			}
		}
		
		int result = -1;
		
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				result = entry.getKey();
			}
		}
		return result;
	}
}
