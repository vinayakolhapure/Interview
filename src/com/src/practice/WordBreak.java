package com.src.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak {

	public static boolean wordBreak(String s, List<String> wordDict) {

		int[] visited = new int[s.length()]; // to avoid going in cycles
		Queue<Integer> queue = new LinkedList<Integer>();

		// put elements of wordDict in HashSet for O(1) contains.
		// Set<String> dict = new HashSet<String>(wordDict);

		// start at 0th index for string
		queue.add(0);

		while (!queue.isEmpty()) {
			int start = queue.poll();

			if (visited[start] == 0) { // if start point is not explored

				for (String word : wordDict) {
					int end = start + word.length();
					if ((end <= s.length()) && (s.substring(start, end).equals(word))) {
						queue.offer(end);
						if (end == s.length())
							return true;
					}
				}

				/*
				 * for(int end = start + 1; end <= s.length(); end++) {
				 * if(dict.contains(s.substring(start,end))) { queue.offer(end); if(end ==
				 * s.length()) return true; } }
				 */
				visited[start] = 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String s = "catsandog";
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

		System.out.println(wordBreak(s, wordDict));
	}
	
	/*
	for "aaaaaaa", wordDict = ["aaaa","aaa"]

	0 1 2 3 4 5 6
	a a a a a a a
	BEGIN
	    1.
	        queue [0]
	        start = 0
	        We find dict words at end 3 (aaa), and end 4 (aaaa) -> add 3 and 4 to queue
	        queue at end of 1st iteration of while queue [3,4]
	    2.
	        start = 3
	        We find dict word at end = 6 (aaa) - add 6 to queue [4,6]
	        We then find dict word (aaaa) at end = 7.
	            also, 7 is end of string - hence return true.
	    
	*/
}
