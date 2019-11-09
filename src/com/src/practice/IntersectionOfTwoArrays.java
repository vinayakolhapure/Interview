package com.src.practice;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		
		int[] result = intersection(nums1, nums2);
		for(int n : result) {
			System.out.print(" " + n);
		}
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		for(int num : nums1) {
			set1.add(num);
		}
		
		for(int num : nums2) {
			set2.add(num);
		}
		
		if(set1.size() >= set2.size())
			return intersectionOfSets(set1, set2);
		else
			return intersectionOfSets(set2, set1);
	}
	
	private static int[] intersectionOfSets(Set<Integer> set1, Set<Integer> set2) {
		int[] result = new int[set1.size()];
		int index = 0;
		
		for(int i : set2) {
			if(set1.contains(i)) {
				result[index++] = i;
			}
		}
		
		return Arrays.copyOf(result, index);
	}
}
