package com.src.practice;

/*     https://leetcode.com/problems/search-insert-position/
 * Given a sorted array and a target value, return the index if the target is found. If not, 
 * 	return the index where it would be if it were inserted in order.
 * 
 * ****You may assume no duplicates in the array.****

		Input: [1,3,5,6], 5
		Output: 2

		Input: [1,3,5,6], 2
		Output: 1

		Input: [1,3,5,6], 7
		Output: 4

		Input: [1,3,5,6], 0
		Output: 0
 * */

class SearchInsertPosition {
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 7;
		
		System.out.println(searchInsert(nums,target));
	}

	public static int searchInsert(int[] nums, int target) {
		int l = nums.length;

		if (target > nums[l - 1]) {
			return l;
		}

		for (int i = 0; i < l; i++) {
			if (nums[i] == target) {
				return i;
			} else {
				if (target < nums[i]) {
					return i;
				}
			}
		}
		return -1;
	}
}
