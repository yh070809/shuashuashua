121. Best Time to Buy and Sell Stock
Easy

6906

302

Add to List

Share
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.



class Solution {
    public int maxProfit(int[] prices) {
       if(prices ==null || prices.length <2){
           return 0;
       }        
       int num = prices.length;  
       int[] min_prices = new int [num];
       int[] max_profit = new int [num]; 
       min_prices[0]= prices[0];
       max_profit[0]= 0;
       for( int i =1 ; i < prices.length ; i++){
           min_prices[i] = Math.min(min_prices[i-1],prices[i]);
           max_profit[i] = Math.max(prices[i] - min_prices[i-1], max_profit[i-1]);
       }
      return   max_profit[num-1];
    }
}