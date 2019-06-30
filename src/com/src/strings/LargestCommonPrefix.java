package com.src.strings;

/*
 * Leetcode 14: https://leetcode.com/problems/longest-common-prefix/
 * 
 * Horizontal scanning
 * 	Consider the first word in the string as the prefix,
 * 		prefix = "flower"
 * 		
 * 		1. flow.indexOf(flower) = -1;
 * 		2. flow.indexOf(flowe) = -1;
 * 		3. flow.indexOf(flow) = 0;  --- out of the while loop
 * 
 * 		new prefix = flow
 * 
 * 		11. flight.indexOf(flow) = -1;
 * 		22. flight.indexOf(flo) = -1;
 * 		32. flight.indexOf(fl) = 0;
 * 
 * 		new prefix = fl
 * 
 * 	*** Different order of inputs -- flow, flower, flight
 * 
 * 		prefix = flow
 * 		
 * 		1. flower.indexOf(flow) = 0 -- out of the while loop
 * 
 * 		prefix = flow
 * 
 * 		1. flight.indexOf(flow) -- Same as 11,22,33 above.
 * */

public class LargestCommonPrefix {
	
	public static void main(String[] args) {
		
		String[] inputArr = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(inputArr));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		
		if(strs == null || strs.length == 0) {
			throw new IllegalArgumentException();
		}
		
		String prefix = strs[0];
		for(int i = 1 ; i < strs.length ; i++) {
			while(strs[i].indexOf(prefix)!=0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.isEmpty()) return "";
			}
		}
		return prefix;
	}
}
