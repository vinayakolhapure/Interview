package com.src.strings;

public class StrStrHaystackNeedle {
	
	public static void main(String[] args) {
		
		System.out.println(strStr("hello", "ll"));
	}
	
	public static int strStr(String haystack, String needle) {
		
		if(needle == null || needle.length() == 0) return 0;
		
		int nL = needle.length();
		
		int i = 0;
		int j = i + nL;
		
		while(j <= haystack.length()) {
			if((haystack.substring(i, j)).equals(needle)) {
				return i;
			}
			i++;
			j++;
		}
		
		return -1;
	}
}