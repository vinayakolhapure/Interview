package com.src.strings;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/*
 * https://leetcode.com/problems/most-common-word/
 * */

public class MostCommonWord {
	public static void main(String[] args) {
		//String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		//String[] banned = { "hit" };
		String paragraph = "Bob. hIt, baLl";
		String[] banned = {"bob", "hit"};
		System.out.println(mostCommonWord(paragraph, banned));
	}

	public static String mostCommonWord(String paragraph, String[] banned) {
		String result = null;
		Map<String,Integer> freq = new HashMap<String,Integer>();
		
		for(String word : banned) {
			freq.put(word,-99);
		}
		
		String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" "); 
		
		for (String word : words) {
			freq.put(word, freq.getOrDefault(word, 0) + 1);
		}
		
		int max = 0;
		
		for(String key : freq.keySet()) {
			int value = freq.get(key);
			if(!(key.equals("")) && value > max) {
				max = value;
				result = key;
			}
		}
		return result;
	}
}
