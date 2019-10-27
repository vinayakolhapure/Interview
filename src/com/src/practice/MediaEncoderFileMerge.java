package com.src.practice;

import java.util.PriorityQueue;

/*
 * There's an Amazon Media Encoder that splits a file into several sub-files of different sizes 
 * 	and a Decoder that puts them back together. The Decoder can merge any two sub-files into one 
 *  and time it takes is the size of the merged sub-file. Given a list of N integers representing 
 *  the sizes of the subfiles, what is the fastest possible time for the Decoder to merge all of 
 *  the files together?
	i.e. Given the file sizes 3, 5, 12, 9, 1; The time it would take is 61:
	
	Solution
	1. init T = 0
	2. i. Add all elements in array to a minHeap
	   ii. while size of the minHeap is > 1
	          Poll 2 elements and add them into sum
	          Add sum to T
	          Add sum back to the minHeap
	3. Return T
	
 * */

public class MediaEncoderFileMerge {

	public static void main(String[] args) {
		int[] fileSizes = {3, 5, 12, 9, 1}; //expected 61
		
		System.out.println(fileEncoder(fileSizes));
	}
	
	public static int fileEncoder(int[] files) {
		int T = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int f : files) {
			pq.add(f);
		}
		
		while(pq.size() > 1) {
			int sum = pq.poll() + pq.poll();
			T += sum;
			pq.offer(sum);
		}
		return T;
	}
}
