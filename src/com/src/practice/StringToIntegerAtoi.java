package com.src.practice;

public class StringToIntegerAtoi {

	public static int myAtoi(String str) {
		long result = 0;
		int sign = 0;
		char[] s = str.toCharArray();
		boolean hasVal = false;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ' && (hasVal || sign != 0))
				break;
			if (s[i] == ' ' && !hasVal)
				continue;
			int in = (int) s[i] - (int) '0';
			if (in < 0 || in > 9) {
				if (s[i] == '-' || s[i] == '+') {
					if (hasVal || sign != 0)
						break;
					sign = s[i] == '+' ? 1 : 2;
					continue;
				}
				break;
			}
			if (!hasVal)
				hasVal = true;
			result *= 10;
			result += in;
			if (result > Integer.MAX_VALUE) {
				result = sign == 2 ? (long) Integer.MIN_VALUE : (long) Integer.MAX_VALUE;
				break;
			}
			
		}
		if (sign == 2 && result != Integer.MIN_VALUE)
			result = -result;
		return (int) result;
	}
	
	public static void main(String[] args) {
		System.out.println(myAtoi("words and 423"));
	}
}
