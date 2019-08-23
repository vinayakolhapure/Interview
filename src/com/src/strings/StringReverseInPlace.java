package com.src.strings;

/*
 * Reverse a String in Place
 * */

public class StringReverseInPlace {
	
	public static void main(String[] args) {
		System.out.println(reverseUsingCharArray("ball"));
		
		System.out.println(reverseUsingStringBuilder("ball"));
	}

	public static String reverseUsingCharArray(String s) {
		int n = s.length() -1;
		int half = s.length() /2;
		
		char[] cArr = s.toCharArray();
		for(int i = 0; i < half ; i++) {
			char temp = cArr[i];
			cArr[i] = cArr[n-i];
			cArr[n-i] = temp;
		}
		return new String(cArr);
	}
	
	public static String reverseUsingStringBuilder(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
