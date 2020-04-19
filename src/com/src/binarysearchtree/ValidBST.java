package com.src.binarysearchtree;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
public class ValidBST {
    public static boolean isValidBST(TreeNode root) {
        //For each node pass around shrinking min and max and check if val is in the range
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean isValidBST(TreeNode node, long min, long max) {
    	
    	if(node != null)
    		System.out.print("Root: "+node.val + " ");
    	
    	System.out.println(" min: "+min + " max: "+max);
        
        //true base case
        if (node == null)
            return true;
        
        //false base case
        if (node.val <= min || node.val >= max)
            return false;
        
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5); 
    	
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(3);
    	
    	root.right = new TreeNode(8);
    	root.right.left = new TreeNode(7);
    	root.right.right = new TreeNode(9);
    	
    	System.out.println(isValidBST(root));
    }
}
