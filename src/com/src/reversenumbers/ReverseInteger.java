package com.src.reversenumbers;

public class ReverseInteger {
	public static void main(String[] args) {
		int input = 2147483647;
		
		System.out.println(reverseInteger(input));
	}
	
	private static int reverseInteger(int input) {
		
		//Integer.MAX_VALUE = 2147483647
		//Integer.MIN_VALUE = -2147483648
		
		int rev = 0;
		
		while(input != 0) {
			int rem = input % 10;
			input /= 10;
			
			if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE && rem > 7))
				return 0;
			if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE && rem < -8))
				return 0;
			
			rev = rev * 10 + rem ;
		}
		
		return rev;
	}
}

