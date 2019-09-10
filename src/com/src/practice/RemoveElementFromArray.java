package com.src.practice;

/*
 * https://leetcode.com/problems/remove-element/
 * 
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * keep i as the spot where a non target element can sit, keep skipping to increment i till you find,
 * 	an elem that is != val
 * */

public class RemoveElementFromArray {
	
	public static void main(String[] args) {
		//1. {3,2,2,3} -- val 3, should return 2
		//2. {0,1,2,2,3,0,4,2} -- val 2, should return 5 (0, 1, 3, 0, 4)
		
		int[] nums = {0,1,2,2,3,0,4,2};
		
		System.out.println(removeElement(nums, 2));
	}
	
	
	public static int removeElement(int[] nums, int val) {
		
		int i = 0;
		
		for(int elem : nums) {
			if(elem != val) {
				nums[i] = elem;
				i++;
			}
		}
		
		return i;
	}
}
