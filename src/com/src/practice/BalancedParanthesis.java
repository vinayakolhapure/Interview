package com.src.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses/
 * */

public class BalancedParanthesis {
	static Map<Character, Character> map = new HashMap<Character, Character>();
	
	static {
		map.put('(',')');
		map.put('[',']');
		map.put('{','}');
	}
	
	public static void main(String[] args) {
		String input = "[{}]";
		
		System.out.println(isValid(input));
	}
	
	private static boolean isOpenParanthesis(char c) {
		if(map.containsKey(c)) {
			return true;
		}
		return false;
	}
	
	private static boolean checkCorrectClosed(char popped, char c) {
		char correct = map.get(popped);
		
		if(correct == c) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isValid(String s) {
		
		char[] input = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < input.length ; i++) {
			if(isOpenParanthesis(input[i])) {
				stack.push(input[i]);
			} else if(stack.isEmpty() || !checkCorrectClosed(stack.pop(), input[i])) {
				return false;
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean isValidSimplified(String s) {        
        Stack<Character> parenthesis = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                parenthesis.push(map.get(c));
            } else if (map.containsValue(c)) {
                if (parenthesis.isEmpty() || parenthesis.pop() != c) {
                    return false;
                }
            }
        }
        return parenthesis.isEmpty();
    }
}
