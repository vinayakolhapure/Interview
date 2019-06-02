package com.src.binarysearchtree;

public class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public void insert(int value) {
		if(value <= data) {
			if(left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else if(value >= data) {
			if(right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}
	}
	
	public boolean contains(int value) {
		if(value == data) {
			return true;
		} else if (value < data) {
			if(left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		} else {
			if(right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}
	}
	
	public void inOrder() {
		if(left != null) {
			left.inOrder();
		}
		System.out.print(" " + data);
		if(right!=null) {
			right.inOrder();
		}
	}
}
