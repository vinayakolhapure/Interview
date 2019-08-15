package com.src.practice;

/*
 * Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * For one pass solution - Apply Kadane's algorithm,
 * 	At i, you consider to sell on day i, what would be with best profit against its current maxProfit
 * 	Also, keep updating the minBuy price
 * 
 * 	Start with minBuy = a[i] and maxProfit = 0;
 * 	At every index, check if a[i]-minBuy is greater than current maxprofit, then update minBuy if a[i] < minBuy
 * */

public class BestTimeBuySellStock121 {
	
	public static int maxProfit(int[] prices) {//Easy solution
        int maxProfit = Integer.MIN_VALUE;
        int currProfit = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
        	for(int j = i+1; j < prices.length; j++) {
        		currProfit = -prices[i] + prices[j];
        		if(currProfit > maxProfit) {
        			maxProfit = currProfit;
        		}
        	}
        }
        if(maxProfit < 0)
        	maxProfit = 0;
        
        return maxProfit;
    }
	
	public static int maxProfitOnePass(int[] prices) {
		int maxProfit = 0;
        if(prices.length == 0 || prices.length == 1)
            return maxProfit;
        
        int minBuy = prices[0];
		
		for(int i = 1; i < prices.length; i++) {
			int profitCheck = prices[i] - minBuy;
			
			if (profitCheck > 0 && profitCheck > maxProfit) {
				maxProfit = profitCheck;
			}
			if (prices[i] < minBuy) {
				minBuy = prices[i];
			}
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
		//7,1,5,3,6,4     7,6,4,3,1
		
		System.out.println(maxProfitOnePass(new int[] {7,1,5,3,6,4}));
	}
}
