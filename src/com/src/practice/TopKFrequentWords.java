package com.src.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class TopKFrequentWords {

	public static List<String> topKFrequent(String[] words, int k) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		//Create simple word, frequency map
		for(String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
		
		//Create PriorityQueue with Increasing order of Frequency (minHeap of frequency),
		//Non-increasing order of word if frequency is same
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String,Integer>>(new Comparator<Map.Entry<String,Integer>> () {
			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				
				if(e1.getValue().equals(e2.getValue()))
					return e2.getKey().compareTo(e1.getKey());
				
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		
		//Add elements (Entry) of frequency map into PriorityQueue
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			pq.add(entry);
			
			if(pq.size() > k)
				pq.poll();
		}
		
		//Comparator for TreeMap - 1. Non-increasing order of frequency (Value), 2. Increasing order of Key (Word)
		Comparator<Map.Entry<String, Integer>> comp = new Comparator<Map.Entry<String,Integer>>() {
			@Override
			public int compare(Entry<String,Integer> e1, Entry<String,Integer> e2) {
				
				//if Frequencies are equal - return increasing order of words
				if(e1.getValue().equals(e2.getValue()))
					return e1.getKey().compareTo(e2.getKey());
				
				//return non-increasing order of frequency
				return e2.getValue().compareTo(e1.getValue());
			}
		};
		
		//As SortedMap/TreeMap can only be sorted on Keys (Natural order, or comparator on KEY Only), we use SortedSet
		SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<Map.Entry<String,Integer>>(comp);
		
		for(Map.Entry<String, Integer> entry : pq) {
			sortedSet.add(entry);
		}
		
		List<String> result = new LinkedList<String>();
		
		for(Map.Entry<String, Integer> entry : sortedSet) {
			result.add(entry.getKey());
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 3;
		
		//String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		//int k = 4;
		
		List<String> result = topKFrequent(words, k);
		
		System.out.println(result.toString());
	}
}
