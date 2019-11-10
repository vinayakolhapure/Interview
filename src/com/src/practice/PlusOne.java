package com.src.practice;

public class PlusOne {
	public static void main(String[] args) {
		//int[] digits = {1,2,3};
		int[] digits = {9};
		
		int[] output = plusOne(digits);
		
		for(int i : output) {
			System.out.print(" " + i);
		}
	
	}
	
	
	public static int[] plusOne(int[] digits) {
		
		int carryOut = 0;
		int index = digits.length - 1;
		
		if(digits[index] == 9) {
			digits[index] = 0;
			carryOut = 1;
			index -= 1;
		} else {
			digits[index] += 1;
		}
		
		while(carryOut != 0 && index > -1) {
			if(digits[index] == 9) {
				digits[index] = 0;
				carryOut = 1;
			} else {
				digits[index] += carryOut;
				carryOut = 0;
			}
			index -= 1;
		}
		
		if(carryOut == 1) {
			int[] newDigits = new int[digits.length+1];
			newDigits[0] = 1;
			for (int i = 1; i < newDigits.length; i++) {
				newDigits[i] = digits[i-1];
			}
			return newDigits;
		}
		
		return digits;
	}
}
