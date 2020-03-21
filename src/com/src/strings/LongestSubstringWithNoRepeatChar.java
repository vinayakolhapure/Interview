package com.src.strings;

import java.util.Map;
import java.util.HashMap;

public class LongestSubstringWithNoRepeatChar {
	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int end = 0; end < s.length(); end++) {
            Character rightChar = s.charAt(end);
            
            if(map.containsKey(rightChar)) {
                start = Math.max(start, map.get(rightChar) + 1);
            }
            map.put(rightChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwpkew"));
		/*
		 * start = 0, end = 0, map [(p,0)], maxLen = 1;
		 * start = 0, end = 1, map [(p,0),(w,1)], maxLen = 2;
		 * start = 0, end = 2, map contains 'w' -- 
		 * 			start = max(0,1 + 1) = 2, map [(p,0),(w,2)]
		 * start = 2, end = 3, Start already ahead of map.get(p) + 1, start = 2
		 * 		 	map [(p,3)(w,2)]
		 * 
		 * we get to wpke as longest string without repeat
		 * */
	}

}
