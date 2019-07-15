package com.src.practice;

/*
 * https://leetcode.com/problems/count-and-say/
 * 		1.     1
		2.     11
		3.     21
		4.     1211
		5.     111221
		
** Thank you to --> https://www.youtube.com/watch?v=kAt-4y0qG8Q
 * */

public class CountNSay {
	public static void main(String[] args) {
		int n = 5;

		System.out.println(countAndSay(n));
	}

	public static String countAndSay(int n) {

		StringBuilder prev = new StringBuilder("1");
		StringBuilder curr = new StringBuilder();

		for (int i = 1; i < n; i++) {
			char currChar = prev.charAt(0);
			int count = 1;

			for (int j = 1; j < prev.length(); j++) {

				if (prev.charAt(j) != currChar) {
					curr.append(count).append(currChar);
					currChar = prev.charAt(j);
					count = 1;
				} else {
					count++;
				}
			}
			curr.append(count).append(currChar);
			prev = curr;
			curr = new StringBuilder();
		}
		return curr.toString();
	}
}
