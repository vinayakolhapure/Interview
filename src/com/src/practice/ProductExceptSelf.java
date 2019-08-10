package com.src.practice;

/*
 * Approach 1
 * 	multiply everything on the left of nums[i] and store in p_left
 * 	multiply everything on right of nums[i] and store in p_right
 * 	multiple elements in p_left and p_right and store in products[];
 * 
 * */

public class ProductExceptSelf {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] products = productExceptSelf2(nums);
		
		for(int i : products) {
			System.out.print(" " + i);
		}
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] p_left = new int[len];
		int[] p_right = new int[len];
		int[] products = new int[len];
		
		int product = 1;
		
		for (int i = 0 ; i < len ; i++) {
			p_left[i] = product;
			product *= nums[i];
		}
		
		product = 1;
		
		for(int i = len -1 ; i >= 0 ; i--) {
			p_right[i] = product;
			product *= nums[i];
		}
		
		for(int i = 0 ; i < len ; i++) {
			products[i] = p_left[i] * p_right[i];
		}
		return products;
	}
	
	public static int[] productExceptSelf2(int[] nums) {
		//Reduce one loop during the right side multiplication
		int len = nums.length;
		int[] products = new int[len];
		int product = 1;
		
		for(int i = 0; i < len ; i++) {
			products[i] = product;
			product *= nums[i];
		}
		
		product = 1;
		
		for(int i = len-1 ; i >= 0 ; i--) {
			products[i] *= product;
			product *= nums[i];
		}
		
		return products;
	}
}
