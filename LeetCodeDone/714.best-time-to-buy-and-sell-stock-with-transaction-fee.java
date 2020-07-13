/*
 * @lc app=leetcode id=714 lang=java
 *
 * [714] Best Time to Buy and Sell Stock with Transaction Fee
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int buy;
        int sell = 0;
        int preBuy = -prices[0];
        int preSell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(preBuy, preSell - prices[i]);
            sell = Math.max(preSell, preBuy + prices[i] - fee);
            preBuy = buy;
            preSell = sell;
        }
        return sell;
    }
}
// @lc code=end

