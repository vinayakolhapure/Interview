package com.src.practice;

/*
 * Test cases
 * 		1. III => 3
 * 		2. IV => 4
 * 		3. IX => 9
 * 		4. LVIII => 58
 * 		5. MCMXCIV = 1000 + 900 (CM) + 90 (XC) + 4 (IV)
 * 
 *
 * */

public class RomanToInteger {
	public static void main(String[] args) {
		String s = "MCMXCIV";
		
		System.out.println(romanToInt(s));
	}
	
	public static int romanToInt(String s) {
		
		int sum = 0;
		int len = s.length();
		
		for(int i=0; i< len ; i++) {
			if(i < len-1 && isRomanCombo(s.substring(i, i+2))) {
				sum += getIntForRomanCombo(s.substring(i,i+2));
				i++;
			} else {
				sum += getIntForRomanChar(s.charAt(i));
			}
		}
		
		return sum;
	}
	
	private static boolean isRomanCombo(String s) {
		String[] combo = {"IV","IX","XL","XC","CD","CM"};
		
		for(String c : combo) {
			if(c.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	private static int getIntForRomanCombo(String s) {
		
		int val = 0;
		
		switch(s) {
		case "IV":
			val = 4;
			break;
		
		case "IX":
			val = 9;
			break;
			
		case "XL":
			val = 40;
			break;
			
		case "XC":
			val = 90;
			break;
		
		case "CD":
			val = 400;
			break;
			
		case "CM":
			val = 900;
			break;
		}
		return val;
	}
	
	private static int getIntForRomanChar(char c) {
		
		int val = 0;
		
		switch(c) {
		case 'I':
			val = 1;
			break;
		
		case 'V':
			val = 5;
			break;
			
		case 'X':
			val = 10;
			break;
			
		case 'L':
			val = 50;
			break;
		
		case 'C':
			val = 100;
			break;
			
		case 'D':
			val = 500;
			break;
			
		case 'M':
			val = 1000;
			break;
		}
		
		return val;
	}
}
