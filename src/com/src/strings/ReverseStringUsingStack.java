package com.src.strings;

import java.util.Stack;

public class ReverseStringUsingStack {
	public static void main(String[] args) {
		String s = "evitative";
		
		System.out.println(reverseStringUsingStack(s));
	}
	
	private static String reverseStringUsingStack(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < s.length() ; i++) {
			stack.push(s.charAt(i));
		}
		
		for(int i=0; i < s.length() ; i++) {
			char c = stack.pop();
			sb.append(c);
		}
		return sb.toString();
	}
}
