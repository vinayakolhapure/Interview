package com.src.strings;

/*
 * O(1) space solution.
 */

class BackspaceStringCompare {
    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skips = 0;
        
        while (i >= 0 || j >= 0) {
            
            //check skips for S and T
            while(i >= 0) {
                if(S.charAt(i) == '#') {
                    //1. increment skips, 2. go to next char
                    skips++;
                    i--;
                } else if (skips > 0) {
                    //if char is not #, but we saw #before
                    //1. decrement skips, 2. skip char by decrementing i
                    skips--;
                    i--;
                } else {
                    break; //Go check for T and go out of inner while loops are run checks below
                }
            }
            
            skips = 0; //reset skips for T
            while (j >= 0) {
                if(T.charAt(j) == '#') {
                    skips++;
                    j--;
                } else if (skips > 0) {
                    skips--;
                    j--;
                } else {
                    break;
                }
            }
            
            if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) //check chars on both strings
                return false;
            if((i >= 0 && j < 0) || (j >=0 && i < 0))
            	return false;
            
            i--;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String S = "xywrrmp";
    	String T = "xywrrmu#p";
    	
    	System.out.println(backspaceCompare(S, T));
    }
}
