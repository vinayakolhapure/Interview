package com.src.strings;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class WordLadder {
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        Queue<String> q = new LinkedList<String>();
        int result = 0;
        
        if(!wordSet.contains(endWord))
        	return 0;
        
        q.offer(beginWord);
        
        while(!q.isEmpty()) {
        	
        	//for each level in the Queue - process the words
        	for (int k = q.size(); k > 0; k--) {
        		
        		String word = q.poll();
        		if(word.equals(endWord)) return result + 1;
        		
        		for (int i = 0; i < word.length(); i++) {
        			char[] newWord = word.toCharArray();
        			for(char ch = 'a'; ch <= 'z'; ch++) {
        				newWord[i] = ch;
        				String s = new String(newWord);
        				if(wordSet.contains(s) && !s.equals(word)) { //to avoid checking the same word again
        					q.offer(s);
        					wordSet.remove(s);
        				}
        			}
        		}
        	}
        	result++;
        }
        return 0;
    }
}
