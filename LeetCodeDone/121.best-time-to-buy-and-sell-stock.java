/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sell = 0;
        int buy = Integer.MIN_VALUE;
        for (int p: prices) {
            sell = Math.max(sell, buy + p);
            buy = Math.max(buy, -p);
        }
        return sell;

    }
}
// @lc code=end

