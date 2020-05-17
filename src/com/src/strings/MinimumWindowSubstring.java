package com.src.strings;

import java.util.Map;
import java.util.HashMap;

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {

		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		int start = 0, minLength = Integer.MAX_VALUE;
		String res = null;

		for (int i = 0; i < t.length(); i++) {
			tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
		}

		for (int end = 0; end < s.length(); end++) {
			char rightChar = s.charAt(end);
			sMap.put(rightChar, sMap.getOrDefault(rightChar, 0) + 1);

			while (matches(sMap,tMap,t.length())) {
				
				if (end - start + 1 < minLength) {
					minLength = end - start + 1;
					res = new String(s.substring(start, end + 1));
				}
				
				char leftChar = s.charAt(start);
				sMap.put(leftChar, sMap.get(leftChar) - 1);
				start++;
			}
		}
		return res;
	}

	private static boolean matches(Map<Character, Integer> s, Map<Character, Integer> t, int n) {
		
		int formed = 0;
		for(Map.Entry<Character,Integer> entry : s.entrySet()) {
			if(t.containsKey(entry.getKey()) && entry.getValue() - t.get(entry.getKey()) >= 0)
				formed += 1;
		}
		return formed == t.size();
	}

	public static void main(String[] args) {
		String s = "aabdec";
		String t = "abc";

		System.out.println(minWindow(s, t));
	}
}
