package com.src.practice;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
		Set<Integer> resSet = new HashSet<Integer>();
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int n : nums1) {
			set.add(n);
		}
		
		for(int i = 0; i < nums2.length; i++) {
			if(set.contains(nums2[i]))
				resSet.add(nums2[i]);
		}
		int[] result = new int[resSet.size()];
		
		int i = 0;
		for(Integer n : resSet) {
			result[i++] = n;
		}
		return result;
	}
}
