package com.src.strings;

/*
 * https://leetcode.com/problems/length-of-last-word/
 * Sample test cases
 * 	" A B"
 *  " A B "
 *  " A "
 *  "A "
 * */

public class LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
	}
	
	public static int lengthOfLastWord(String s) {
		s = s.trim(); //remove leading and trailing spaces
        
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        if(s.lastIndexOf(" ") == -1) //check if there is only one word in the string
            return s.length();
        
        String lastWord = s.substring(s.lastIndexOf(" ") + 1);
        return lastWord.length();
	}
}
