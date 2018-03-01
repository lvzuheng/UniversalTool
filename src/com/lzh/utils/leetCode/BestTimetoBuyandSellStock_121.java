package com.lzh.utils.leetCode;

public class BestTimetoBuyandSellStock_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {4,7,2,1};
		System.out.println(maxProfit(input));
	}


	 public static int maxProfit(int[] prices) {
	        if(prices.length<=1)
	            return 0;
	        int a = Integer.MAX_VALUE;
	        int value = 0;
	        for(int i = 0;i<prices.length;i++){
	        	if(prices[i] < a){
	        		a = prices[i];
	        	}else if(value < prices[i] - a){
	        		value = prices[i] - a;
	        	}
	        }
	        return value;
	    }
}
