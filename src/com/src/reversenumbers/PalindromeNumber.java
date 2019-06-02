package com.src.reversenumbers;

public class PalindromeNumber {
	public static void main(String[] args) {
		
		int input = 1221;
		
		System.out.println(isPalindrome(input));
	}
	
	private static boolean isPalindrome(int input) {
		
		//keep a copy of input as you will be modifying it when reversing the number
		int copy = input;
		
		int rev = 0;
		int rem = 0;
		
		while(copy!=0) {
			rem = copy % 10;
			copy /=10;
			rev = rev *10 + rem;
		}
		
		return input == rev;
	}
}
