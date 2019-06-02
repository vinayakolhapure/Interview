package com.src.binarysearchtree;

import com.src.binarysearchtree.Node;

public class BSTSolution {
	public static void main(String[] args) {
		Node root = new Node(5);
		
		root.insert(3);
		root.insert(2);
		root.insert(4);
		
		root.insert(8);
		root.insert(6);
		root.insert(9);
		
		
		root.inOrder();
		System.out.println(" ");
		
		System.out.println(root.contains(11));
		System.out.println(root.contains(4));
		
		
		System.out.println(root.checkBST(root));
	}
}
