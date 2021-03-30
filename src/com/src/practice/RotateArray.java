package com.src.practice;

/*
 * We use an extra array in which we place every element of the array at its correct position 
 * i.e. the number at index i in the original array is placed at the index 
 * 					(i+k)%(length of array). 
 * take modulo to handle cases where k is greater than the length of list
 * Then, we copy the new array to the original one.
 * */

public class RotateArray {

	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7};
		int k = 3;
		
		rotateArray(A,k);
		for(int i : A) {
			System.out.print(" " + i);
		}
	}
	
	public static void rotateArray(int[] nums, int k) {
		int[] temp = new int[nums.length];
		for (int i = 0; i<nums.length; i++) {
			temp[(i+k)%nums.length] = nums[i];
		}
		
		for(int i = 0; i<nums.length; i++) {
			nums[i] = temp[i];
		}
	}
}
