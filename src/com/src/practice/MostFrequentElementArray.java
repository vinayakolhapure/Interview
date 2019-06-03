package com.src.practice;

/*
 * Find the most frequent element in the given array
 * 
 * 1. use a running max value initialized to Integer.MIN_VALUE
 * 2. use a hash map to store/maintain the frequency of each element in the array
 * 3. from the hash map and max value -- iterate over the hash map to find which element occurs most times
 * 	3a. It could be more than one element that is frequent - hence return a set.
 * 
 * */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostFrequentElementArray {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 3, 2, 1, 4, 1, 5, 5, 5};
		
		Set<Integer> result = findMostFrequent(arr);
		
		System.out.println(result.toString());
	}
	
	private static Set<Integer> findMostFrequent(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int max = Integer.MIN_VALUE;
		
		for(int i : arr) {
			if(map.containsKey(i)) {
				int freq = map.get(i);
				freq += 1;
				map.put(i, freq);
				
				if(freq > max)
					max = freq;
			} else {
				map.put(i, 1);
				
				if(1 > max)
					max = 1;
			}
		}
		
		return findMaxKeys(map, max);
	}

	private static Set<Integer> findMaxKeys(Map<Integer, Integer> map, int max) {
		
		Set<Integer> result = new HashSet<Integer>();
		
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == max) {
				result.add(entry.getKey());
			}
		}
		
		return result;
	}
}
