package com.src.practice;

import java.util.Arrays;

public class IntersectionOfTwoArrays2 {
	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		
		int[] result = intersection(nums1, nums2);
		for(int n : result) {
			System.out.print(" " + n);
		}
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int[] result = new int[nums1.length >= nums2.length ? nums1.length : nums2.length];
		
		int i = 0, j = 0, ind = 0;
		
		while (i < nums1.length && j < nums2.length) {
			if(nums1[i] == nums2[j]) {
				result[ind++] = nums1[i];
				i++;
				j++;
			} else if(nums1[i] < nums2[j]) {
				i++;
			} else if(nums2[j] < nums1[i]) {
				j++;
			}
		}
		return Arrays.copyOf(result, ind);
	}
}
