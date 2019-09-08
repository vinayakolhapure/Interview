package com.src.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 
 * 347. Top K Frequent Elements: https://leetcode.com/problems/top-k-frequent-elements/description/
 * Given a non-empty array of integers, return the k most frequent elements.
 * Input: nums = [1], k = 1
   Output: [1]
 * */

public class TopKFrequentElements {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 2, 2, 3 };
		List<Integer> list = topKFrequent(nums, 2);

		System.out.println(list.toString());
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
				(a, b) -> (b.getValue() - a.getValue()));

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}

		List<Integer> list = new ArrayList<Integer>();

		while (list.size() < k) {
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			list.add(entry.getKey());
		}
		return list;
	}

}
