package com.src.binarysearchtree;

import com.src.binarysearchtree.Node;

public class MirrorOfBinaryTree {
	
	public static void main(String[] args) {
		Node root = new Node(5);
		
		root.insert(3); root.insert(2); root.insert(4);
		root.insert(8); root.insert(6); root.insert(9);

		root.inOrder();
		System.out.println(" ");
		
		Node mirror = mirrorBT(root);
		
		mirror.inOrder();
		System.out.println(" ");
		System.out.println(mirror.checkBST(mirror));
	}

	public static Node mirrorBT(Node root) {

		if (root != null) {

			mirrorBT(root.left);
			mirrorBT(root.right);
			
			//swap
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}
}
