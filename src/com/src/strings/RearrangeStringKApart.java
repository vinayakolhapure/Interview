package com.src.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKApart {
	public static String rearrangeString(String s, int k) {
		if (s == null || s.length() == 0 || k < 0)
			return "";
		if (k == 0)
			return s;

		int len = s.length();

		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray())
			map.put(c, map.getOrDefault(c,0) + 1);

		Comparator<Map.Entry<Character, Integer>> comparator = ((e1, e2) -> e1.getValue() == e2.getValue()
				? Character.compare(e1.getKey(), e2.getKey())
				: Integer.compare(e2.getValue(), e1.getValue()));

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				comparator);

		maxHeap.addAll(map.entrySet());

		Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		while (!maxHeap.isEmpty()) {

			Map.Entry<Character, Integer> e = maxHeap.poll();
			sb.append(e.getKey());
			e.setValue(e.getValue() - 1);

			waitQueue.offer(e);

			if (waitQueue.size() < k)
				continue;

			e = waitQueue.poll();

			if (e.getValue() > 0)
				maxHeap.offer(e);
		}

		return sb.length() == s.length() ? sb.toString() : "";
	}
	
	public static void main(String[] args) {
		String s = "aaabc";
		int k = 3;
		
		System.out.println(rearrangeString(s, k));
	}
}
