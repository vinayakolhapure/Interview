package com.src.strings;

/*
 * Interview problem
 * 
 * Given
 * An encoded string (encode function source code given too)
 * 
 * Objective
 * Write the function to decode the encoded string and return the original string.
 * 
 * The encoding logic is as below,
 * 
 * Each char in the string is encoded as - ASCII Code of the char * 2 (c + c) + i
 * Each encoded char is then appended to a StringBuilder, and the reverse is returned.
 * 
 * So, make sure when you are decoding char at i - that is nothing but char at len-1
 * 
 * Decode by decreasing index from int value of char at i (index is reversed, so at 0 of encoded 
 * 	string, it is len-1-0. Then divide this by 2 and append to StringBuilder.
 * 
 * Return reverse at the end to get back the original string.
 * */

public class StringEncodeDecodeBR {
	public static void main(String[] args) {
		String input = "abc";
		
		String encoded = encode(input);
		System.out.println(decode(encoded));
	}
	
	public static String encode(String s) {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			b.append(c += c + i); //c = (char) (c + c + i)
		}
		return b.reverse().toString();
	}
	
	public static String decode(String s) {
		StringBuilder b = new StringBuilder();
		int lenMinusOne = s.length()-1;
		for (int i = 0; i <= lenMinusOne ; i++) {
			int val = (int) s.charAt(i);
			int finalVal = (val - (lenMinusOne-i)) /2;
			b.append((char) finalVal);
		}
		return b.reverse().toString();
	}
	
	//Same logic - slightly different approach
	private static String decode2(String text) {
		StringBuilder b = new StringBuilder();
		//Reverse the reversed string
		int dec = text.length()-1;
		for (int i = 0; i <text.length() ; i++) {
			int ch = text.charAt(i);
			ch -= dec;
			ch /= 2;
			dec--;
			b.append((char)ch);
		}
        return b.reverse().toString();
	}
}
