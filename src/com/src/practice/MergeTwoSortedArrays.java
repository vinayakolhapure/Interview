package com.src.practice;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] nums1 = {4,8,10,10};
		int[] nums2 = {2,3,6,7,13,14};
		
		int[] merged = mergeTwoSortedArrays(nums1,nums2);
		
		for(int i : merged) {
			System.out.print(" " + i);
		}
	}
	
	public static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
		
		int n1 = nums1.length;
		int n2 = nums2.length;
		
		int[] merged = new int[n1+n2];
		
		int index = 0;
		int i=0;
		int j=0;
		
		while (i < n1 && j < n2) {
			if(nums1[i] < nums2[j]) {
				merged[index] = nums1[i];
				i++;
			} else {
				merged[index] = nums2[j];
				j++;
			}
			index++;
		}
		
		while(i < n1) {
			merged[index] = nums1[i];
			index++;
			i++;
		}
		
		while(j < n2) {
			merged[index] = nums2[j];
			index++;
			j++;
		}
		
		return merged;
	}
}
