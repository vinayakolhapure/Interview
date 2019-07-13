package com.src.practice;

/*
 * The requirement is not to "remove" the duplicates as such,
 * 	but return the length (n) of the array with first n unique elements,
 * 	it doesn't matter what comes after n in the array.
 * 
 * 	In this solution, we keep visiting next element and compare it to curr, 
 *  by using 2 pointers, i = 0, j = 1 -- and swap a[i] = a[j]
 *  as long as duplicates are encountered, they are skipped and j is incremented,
 *  when we get a[i]!=a[j], we increment i and do the swap.
 *  
 *  The final array remaining for the input {0,0,1,1,1,2,2,3,3,4} will be,
 *  		{0,1,2,3,4,2,2,3,3,4,4}.
 *  It doesn't matter what comes after 4.
 *  
 *  
 *  REMOVE DUP EASY TO UNDERSTAND -- removeDupEasyToUnderstand(int[] nums) method
 *  
 *  start with orig as nums[0] and targetIndex as 1. As soon as you find a number where number != orig,
 *  	1. make orig = number, 2. put number in targetIndex, 3. increment target index.
 *  
 *  0 0 1 1 1 2 2 3 3 4
 *  
 *  0 1 1 1 1 2 2 3 3 4 (2.)
 *  0 1 2 1 1 2 2 3 3 4 (5.)
 *  0 1 2 3 1 2 2 3 3 4 (7.)
 *  0 1 2 3 4 2 2 3 3 4 (9.)
 *  
 *  1. target = 1, orig = 0, i = 1 --? == next iter
 *  2. target = 1, orig = 0, i = 2 --? != a[target] = nums[i], orig = nums[i], target++
 *  3. target = 2, orig = 1, i = 3 --? ==
 *  4. 						 i = 4 --? ==
 *  5. target = 2, orig = 1, i = 5 --? != a[target] = nums[i], orig = nums[i], target++
 *  6. target = 3, orig = 2, i = 6 --? ==
 *  7. target = 3, orig = 2, i = 7 --? != a[target] = nums[i], orig = nums[i], target++
 *  8. target = 4, orig = 3, i = 8 --? ==
 *  9. target = 4, orig = 3, i = 9 --? != a[target] = nums[i], orig = nums[i], target++
 * */

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		// int[] arr = {1,1,2};

		int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		int l = removeDuplicates(arr);

		System.out.println(l);
	}

	public static int removeDupEasyToUnderstand(int[] nums) {
		int length = nums.length;

		if (length == 0)
			return 0;

		int orig = nums[0];
		int targetIndex = 1;

		for (int i = 1; i < length; i++) {
			if (orig != nums[i]) {
				orig = nums[i];
				nums[targetIndex] = nums[i];
				targetIndex++;
			}
		}
		return targetIndex;
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
}
