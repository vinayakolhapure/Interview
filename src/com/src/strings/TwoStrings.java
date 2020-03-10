package com.src.strings;


/*
 * 
 * */
public class TwoStrings {

	public static String twoStrings(String s1, String s2) {

		char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
				'r','s','t','u','v','w','x','y','z'};
        
        for(char c : alph) {
            if(s1.indexOf(c) != -1 && s2.indexOf(c) != -1) {
                return "YES";
            }
        }
        return "NO";
    }
	
	public static void main(String[] args) {
		System.out.println(twoStrings("hi","world"));
	}
}
