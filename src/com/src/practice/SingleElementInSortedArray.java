package com.src.practice;

public class SingleElementInSortedArray {

	//O(logN)
	
	public static void main(String[] args) {
		/*
		 * Example 1:
				Input: [1,1,2,3,3,4,4,8,8]
				Output: 2

		   Example 2:
				Input: [3,3,7,7,10,11,11]
				Output: 10
		 * */
		
		System.out.println(singleElement(new int[] {1,1,2,3,3,4,4,8,8}));
	}
	
	public static int singleElement(int[] nums) {
		int start = 0, end = nums.length - 1, mid;
		
		while (start < end) {
			mid = start + (end - start)/2;
			
			int midElem = nums[mid];
			int midXORElem = nums[mid^1];
			
			if(midElem == midXORElem) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		
		return nums[start];
	}
}
