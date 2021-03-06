package com.src.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {

	public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet<String>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
            	
            	for (String word : wordDict) {
                    int end = start + word.length();
                    if((end <= s.length()) && (s.substring(start, end).equals(word))) {
                        queue.offer(end);
                        if (end == s.length())
                            return true;
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }
	
	public static void main (String[] args) {
		String s = "catsanddog";//"catsandog" would be false;
		List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println(wordBreak(s,wordDict));
	}
}
