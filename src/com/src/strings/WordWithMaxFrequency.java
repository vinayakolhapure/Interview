package com.src.strings;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Return the word with the max frequency
 * 	if more than one word has the same highest frequency, return the first word for that frequency
 * 	"Word", "WORD", "word" are treated the same key
 * 
 * input is a string array
 * */

public class WordWithMaxFrequency {
	public static void main(String[] args) {
		String[] input = {"word", "Word", "Hello", "hello", "Hello", "world", "world", "world", "nyc" };

		System.out.println(findWordWithMaxFrequency(input));
		
	}
	
	private static String findWordWithMaxFrequency(String[] input) {
		
		int max = Integer.MIN_VALUE;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String output = null;
		
		for(String s : input) {
			s = s.trim();
			s = s.toLowerCase();
			if(!map.containsKey(s)) {
				map.put(s, 1);
				if(max<1) {
					max = 1;
					output = s;
				}
			} else {
				int freq = map.get(s);
				freq += 1;
				map.put(s, freq);
				if(max < freq) {
					max = freq;
					output = s;
				}
			}
		}
		return output;
	}
}
