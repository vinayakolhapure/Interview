package com.src.strings;

import java.util.Map;
import java.util.HashMap;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("z"));
	}
	
	public static int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++) {
        	freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++) {
        	if(freq.get(s.charAt(i)) == 1) {
        		return i;
        	}
        }
        return -1;
    }
}
