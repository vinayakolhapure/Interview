package com.src.strings;

class IntegerToWords {
    private final static String[] oneDigit = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
    		"Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
    		"Seventeen", "Eighteen", "Nineteen"};
    
    private final static String[] twoDigits = {"", "", "Twenty", "Thirty", "Forty", 
    		"Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private final static String[] threeDigits = {"", "Thousand", "Million", "Billion"};
    
    
    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        StringBuilder sb = new StringBuilder();
        int remainingVal = num;
        int commas = 0;
        
        while (remainingVal != 0) {
            String word = processUpToThreeDigits(remainingVal % 1000);

            remainingVal = remainingVal / 1000;
            
            if (word.length() > 0 && commas > 0) {
                sb.insert(0, threeDigits[commas] + " ");
            }
            
            sb.insert(0, word); // prepend
            
            commas++;
        }
        
        return sb.toString().trim();
    }
    
    private static String processUpToThreeDigits(int val) {
        String str = "";
        
        if (val > 99) {
            str = oneDigit[val / 100];
            str += " Hundred ";
            val = val % 100;
        }
        
        if (val > 19)  {
            str += twoDigits[val / 10] + " ";
             val = val % 10;
        }
        
        if (val > 0) {
            str += oneDigit[val] + " ";
        }
        
        return str;
    }
    
    public static void main(String[] args) {
    	System.out.println(numberToWords(1000000));
    }
}
