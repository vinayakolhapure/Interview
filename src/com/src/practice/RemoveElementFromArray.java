package com.src.practice;

/*
 * https://leetcode.com/problems/remove-element/
 * */

public class RemoveElementFromArray {
	
	public static void main(String[] args) {
		//1. {3,2,2,3}
		//2. {0,1,2,2,3,0,4,2}
		
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
