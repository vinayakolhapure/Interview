package com.src.practice;

import java.util.Arrays;
import java.util.Collections;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		rotate(matrix);
		
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(Arrays.toString(matrix[1]));
		System.out.println(Arrays.toString(matrix[2]));
	}
	
	public static void rotate(int[][] matrix) {
		//1. Reverse the array, i.e., 1st row becomes last, and last row becomes first - Row level reverse
		Collections.reverse(Arrays.asList(matrix));
		
		//2. Transpose, i.e., cols become rows
		for(int row = 0; row < matrix.length; row++) {
			for(int col = row; col < matrix[0].length; col++) {
				int temp = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}
	}
}
