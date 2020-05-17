package com.src.practice;

import java.util.LinkedList;
import java.util.List;

public class FindKClosestElements {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,2,3,4,5};
		int x = -1;
		int k = 4;
		
		List<Integer> list = findClosestElements(arr, k, x);
		System.out.println(list.toString());
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x)     {
        // provided k >= 1
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) /2;
            // this determines how to shift the range
            if ( Math.abs(arr[mid] -x)  > Math.abs(arr[mid + k] - x) ) {
                // because the range can start from mid + 1 as the
                // arr[mid] is more than the arr[mid+k]
                left = mid + 1;
            } else { // arr[mid] - x <= arr[mid+k] - x
                // then, this range [mid, mid + k - 1] is safe comparing to  mid + k because of this comparison!!!!!!!
                right = mid;
            }
        }

        List<Integer> list = new LinkedList<>();
        for (int i = left; i < left + k; i++) {
            list.add(arr[i]);
        }

        return list;
        
    }
}
