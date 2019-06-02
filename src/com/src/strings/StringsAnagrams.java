package com.src.strings;

import java.util.Arrays;

/*
 * Process
 * 1. convert string to char array
 * 2. sort the char array
 * 3. convert the array back to string.
 * 
 * Optional - can return hashCode of the converted string and compare the hash codes.
 * */

public class StringsAnagrams {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "bac";
		
		System.out.println(isAnagram(s1, s2));
	}
	
	public static boolean isAnagram(String s1, String s2) {
		
		String processed1 = getProcessedString(s1);
		
		String processed2 = getProcessedString(s2);
		
		return processed1.equals(processed2);
	}
	
	public static String getProcessedString(String s) {
		
		char[] charArray = s.toCharArray();
		
		Arrays.sort(charArray);
		
		return String.valueOf(charArray);
	}
}
