package com.src.practice;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] nums = {2,4,1,6,8,5,3,7,9,10,11,12,21,19,28,18};
		
		//int[] sorted = mergeSort(nums);
		mergeSort(nums);
		
		for(int i : nums) {
			System.out.print(" " + i);
		}
	}
	
	public static void mergeSort(int[] A) {
		
		int n = A.length;
		
		if(n < 2) {//base/exit condition for the recursive algorithm
			//return A;
			return;
		}
		
		int mid = n/2;
		
		int[] left = new int[mid]; //left array 0 to mid
		int[] right = new int[n-mid]; //right array mid+1 to n
		
		for(int i=0; i < mid; i++) {
			left[i] = A[i]; //fill in left array
		}
		
		for(int i=0; i < n-mid; i++) {
			right[i] = A[mid+i]; //fill in right array
		}
		
		mergeSort(left);
		mergeSort(right);
		
		merge(left,right,A);
		
		//return A;
	}
	
	public static void merge(int[] left, int[] right, int[] A) {
		
		int i = 0;
		int j = 0;
		int index = 0;
		
		while(i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				A[index] = left[i];
				i++;
			} else {
				A[index] = right[j];
				j++;
			}
			index++;
		}
		
		while(i < left.length) {
			A[index] = left[i];
			i++;
			index++;
		}
		
		while(j < right.length) {
			A[index] = right[j];
			j++;
			index++;
		}
		
		//return A;
	}
}

