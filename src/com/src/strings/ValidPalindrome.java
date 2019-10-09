package com.src.strings;

/*
 * https://leetcode.com/problems/valid-palindrome/
 * */

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(isPalindromeWithoutReplace("A man, a plan, a canal: Panama"));
	}
	
	public static boolean isPalindrome(String s) {
		
		//Slow due to replaceAll regex
		
		if(s == null || s.length() <= 0) return true;
		
        String clean = s.replaceAll("[^a-zA-Z0-9]", "");
        
        StringBuilder sb = new StringBuilder(clean);
        return sb.reverse().toString().equalsIgnoreCase(clean);
    }
	
	public static boolean isPalindromeWithoutSB(String s) {
		
		//Slow due to replaceAll regex and n compare (while loop)
		
		if(s == null || s.length() <= 0) return true;
		
		String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		
		
		int head = 0;
		int tail = clean.length() - 1;
		
		while(head < tail) {
			if(clean.charAt(head) != clean.charAt(tail))
				return false;
			
			head++;
			tail--;
		}
		return true;
	}
	
	public static boolean isPalindromeWithoutReplace(String s) {
		if(s == null || s.length() <= 0) return true;
		
		s = s.toLowerCase();
		
		int head = 0;
		int tail = s.length() - 1;
		
		while(head < tail) {
			if(!isCharValid(s.charAt(head))) {
				head++;
			} else if(!isCharValid(s.charAt(tail))) {
				tail--;
			} else {
				if(s.charAt(head) != s.charAt(tail)) {
					return false;
				}
				head++;
				tail--;
			}
		}
		return true;
	}
	
	private static boolean isCharValid(char c) {
		if (c >= 97 && c <= 122) {
			return true;
		} else if (c >= 48 && c <= 57) {
			return true;
		}
		return false;
	}
}
